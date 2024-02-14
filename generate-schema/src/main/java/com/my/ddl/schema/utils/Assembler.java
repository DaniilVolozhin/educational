package com.my.ddl.schema.utils;

import com.my.ddl.schema.model.Column;
import com.my.ddl.schema.model.HibernateAnnotation;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.BooleanMemberValue;
import javassist.bytecode.annotation.ClassMemberValue;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class Assembler {
	public static CtField addNewFiled(CtClass type, String name, CtClass ctc) {
		CtField f = null;
		try {
			f = new CtField(type, name, ctc);
			f.setModifiers(Modifier.PRIVATE);
			ctc.addField(f);
		}
		catch (CannotCompileException ex) {
			ex.printStackTrace();
			throw new IllegalArgumentException("Failed to create a field.", ex);
		}

		return f;
	}

	public static void addAnnotationOnClass(ConstPool constPool, ClassFile classFile, HibernateAnnotation hibernateAnnotation) {
		AnnotationsAttribute annotationsAttribute = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
		Annotation annotation = new Annotation(hibernateAnnotation.getPathAnnotation(), constPool);

		annotationsAttribute.addAnnotation(annotation);
		classFile.addAttribute(annotationsAttribute);
	}

	public static void addAnnotationField(ConstPool cp, CtField f, HibernateAnnotation hibernateAnnotation) {
		AnnotationsAttribute attribute = Optional
				.ofNullable(f.getFieldInfo().getAttribute(AnnotationsAttribute.visibleTag))
				.map((info) -> (AnnotationsAttribute) info)
				.orElse(new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag));

		Annotation annotation = new Annotation(hibernateAnnotation.getPathAnnotation(), cp);
		attribute.addAnnotation(annotation);
		f.getFieldInfo().addAttribute(attribute);
	}

	public static void addAnnotationColumnNullable(ConstPool cp, CtField f) {
		AnnotationsAttribute attribute = Optional
				.ofNullable(f.getFieldInfo().getAttribute(AnnotationsAttribute.visibleTag))
				.map((info) -> (AnnotationsAttribute) info)
				.orElse(new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag));

		Annotation annotation = new Annotation(HibernateAnnotation.COLUMN.getPathAnnotation(), cp);
		annotation.addMemberValue("nullable", new BooleanMemberValue(false, cp));
		attribute.addAnnotation(annotation);
		f.getFieldInfo().addAttribute(attribute);
	}

	public static void addFieldAndAnnotationRelation(String name, String javaType, HibernateAnnotation hibernateAnnotation, CtClass ctClass) {
		ClassPool classPool = ClassPool.getDefault();
		CtField ctField;
		try {
			ctField = Assembler.addNewFiled(classPool.get(javaType), name.toLowerCase(), ctClass);
		} catch (NotFoundException e) {
			throw new IllegalArgumentException("This relation: " + name + " is not established.", e);
		}
		addAnnotationByRelation(name, ctClass.getClassFile().getConstPool(), ctField, hibernateAnnotation);
	}

	private static void addAnnotationByRelation(String targetName, ConstPool cp, CtField f, HibernateAnnotation hibernateAnnotation) {
		AnnotationsAttribute attribute = Optional.ofNullable(f.getFieldInfo()
				.getAttribute(AnnotationsAttribute.visibleTag))
				.map((info) -> (AnnotationsAttribute) info)
				.orElse(new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag));

		Annotation annotation = new Annotation(hibernateAnnotation.getPathAnnotation(), cp);
		annotation.addMemberValue("targetEntity", new ClassMemberValue(targetName ,cp));

		attribute.addAnnotation(annotation);
		f.getFieldInfo().addAttribute(attribute);
	}

	public static void addPrimitiveField(Column column, CtClass ctClass, ClassPool classPool) {
		if (nonNull(column)) {
			try {
				CtField ctField = Assembler.addNewFiled(classPool.get(column.getType()), column.getName(), ctClass);
				if (column.isRequired()) {
					Assembler.addAnnotationColumnNullable(ctField.getFieldInfo().getConstPool(), ctField);
				}
			} catch (NotFoundException e) {
				e.printStackTrace();
				throw new IllegalArgumentException("This type: " + column.getType() + " can't be created", e);
			}
		}
	}


	public static void addIdFieldAndAnnotate(CtClass ctClass, ConstPool constPool) {
		CtField idField = Assembler.addNewFiled(CtClass.longType, "id", ctClass);
		Assembler.addAnnotationField(constPool, idField, HibernateAnnotation.ID);
		Assembler.addAnnotationField(constPool, idField, HibernateAnnotation.GENERATED_VALUE);
	}

}
