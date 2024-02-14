package com.my.ddl.schema.service;

import com.my.ddl.schema.entity.Attribute;
import com.my.ddl.schema.entity.Entity;
import com.my.ddl.schema.entity.RelationType;
import com.my.ddl.schema.model.Column;
import com.my.ddl.schema.model.JavaType;
import com.my.ddl.schema.model.Table;
import com.my.ddl.schema.repostiory.EntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class TransformService {

    private final EntityRepository entityRepository;

    public List<Table> findProjectAndTransform(UUID dbId) {
        List<Entity> entityList =
                entityRepository.findByDbId(dbId);

        List<Table> tableList = new ArrayList<>();

        entityList.forEach(area -> transformEntityToTable(area, tableList));

        return tableList;
    }

    private void transformEntityToTable(Entity entity, List<Table> fillTableList) {
        List<Column> columnList = entity.getAttribute().stream()
                .map(entityAttribute -> transformAttributeToColumn(entityAttribute, entityAttribute.isRequired()))
                .collect(toList());

        Table table = new Table();
        table.setColumns(columnList);
        table.setName(entity.getName());
        entity.getAttribute().forEach(relation -> transformRelationInTable(relation, table));

        fillTableList.add(table);
    }

    private void transformRelationInTable(Attribute attribute, Table table) {
        RelationType relationType = attribute.getRelationType();
        table.getColumns()
                .stream()
                .filter(column -> column.getName().equals(attribute.getName()))
                .forEach(column -> column.setRelationType(attribute.getRelationType()));
    }

    private Column transformAttributeToColumn(Attribute attribute, boolean required) {
        return Column.builder()
                .name(attribute.getName())
                .type(getTypeByAttributeType(attribute.getAttributeType()))
                .required(required)
                .build();
    }

    private String getTypeByAttributeType(String attributeType) {
        return JavaType.valueOf(attributeType.toUpperCase()).getJavaType();
    }
}
