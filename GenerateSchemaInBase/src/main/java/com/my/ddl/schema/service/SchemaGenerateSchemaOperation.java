package com.my.ddl.schema.service;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.stereotype.Component;
import com.my.ddl.schema.model.HibernateAnnotation;
import com.my.ddl.schema.model.Table;
import com.my.ddl.schema.utils.Assembler;

import java.util.*;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

@Component
public class SchemaGenerateSchemaOperation implements SchemaOperation {

	@Override
	public void execute(List<Table> tables, Map<String, String> settings) {
		Map<Table, CtClass> tableCtClassMap = tables.stream().collect(toMap(table -> table, this::createCtClass));
		addRelation(tableCtClassMap);
		generateSchema(tableCtClassMap.values() ,settings);
	}

	private CtClass createCtClass(Table table) {
		final String tableName = table.getName();

		ClassPool classPool = ClassPool.getDefault();

		if (Optional.ofNullable(classPool.getOrNull(tableName)).isEmpty()) {
			CtClass ctClass = classPool.makeClass(tableName);
			ClassFile classFile = ctClass.getClassFile();
			ConstPool constPool = classFile.getConstPool();

			Assembler.addAnnotationOnClass(constPool, classFile, HibernateAnnotation.ENTITY);

			Assembler.addIdFieldAndAnnotate(ctClass, constPool);

			if (nonNull(table.getColumns())) {
				table.getColumns().forEach(column -> Assembler.addPrimitiveField(column, ctClass, classPool));
			}

			return ctClass;
		}
		throw new IllegalArgumentException("The entity exists: " + tableName);

	}

	private void addRelation(Map<Table, CtClass> ctClassList) {
		ctClassList.forEach((table, ctClass) ->
		{
			if (nonNull(table.getOneToOne())) {
				table.getOneToOne()
						.forEach(oneToOneName -> Assembler.addFieldAndAnnotationRelation(oneToOneName, oneToOneName, HibernateAnnotation.ONE_TO_ONE, ctClass));
			}
			if (nonNull(table.getManyToOne())) {
				table.getManyToOne()
						.forEach(manyToOne -> Assembler.addFieldAndAnnotationRelation(manyToOne, manyToOne, HibernateAnnotation.MANY_TO_ONE, ctClass));
			}
			if (nonNull(table.getManyToMany())) {
				table.getManyToMany()
						.forEach(manyToMany -> Assembler.addFieldAndAnnotationRelation(manyToMany, "java.util.List", HibernateAnnotation.MANY_TO_MANY, ctClass));
			}
		});
	}

	private void generateSchema(Collection<CtClass> ctClassList, Map<String, String> settings) {
		ClassPool classPool = ClassPool.getDefault();
		MetadataSources metadataSources = new MetadataSources(new StandardServiceRegistryBuilder()
				.applySettings(settings)
				.build());

		ctClassList.stream().map(ctClass ->
		{
			try {
				Class<?> clazz = classPool.toClass(ctClass);
				ctClass.defrost();
				return clazz;
			} catch (CannotCompileException e) {
				throw new IllegalArgumentException("Object not created", e);
			}
		}).forEach(metadataSources::addAnnotatedClass);

		new SchemaExport()
				.setFormat(true)
				.setHaltOnError(false)
				.setDelimiter(";")
				.create(EnumSet.of(TargetType.DATABASE, TargetType.STDOUT), metadataSources.buildMetadata());
	}

}
