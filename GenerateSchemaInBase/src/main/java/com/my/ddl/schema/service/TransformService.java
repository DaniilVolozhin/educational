package com.my.ddl.schema.service;

import com.my.ddl.schema.entity.*;
import com.my.ddl.schema.model.Column;
import com.my.ddl.schema.model.Table;
import com.my.ddl.schema.repostiory.SchemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.my.ddl.chema.entity.*;
import com.my.ddl.schema.model.AttributeType;

import javax.persistence.EntityNotFoundException;
import java.util.*;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class TransformService {

    private final SchemaRepository schemaRepository;

    public Map<DataSource, List<Table>> findProjectAndTransform(UUID schemaId) {
        Schema schema =
                schemaRepository.findById(schemaId)
                        .orElseThrow(() -> new EntityNotFoundException("Entity with id: " + schemaId + " not found"));

        Map<DataSource, List<Table>> dataSourceTablesMap = new HashMap<>();
        DataSource dataSourceProject = new DataSource();/*schema.getSource().getDbPersistentSource();*/
//        dataSourceProject.setDataSourceType();

        schema.getArea()
                .forEach(area -> iterateDataAreaEntity(area, dataSourceTablesMap, dataSourceProject));

        return dataSourceTablesMap;

    }

    private void iterateDataAreaEntity(Area area, Map<DataSource, List<Table>> dataSourceTablesMap, DataSource dataSource) {
        if (nonNull(area.getSourceBySave()) && nonNull(area.getSourceBySave())) {
            dataSource = area.getSourceBySave();
        }

        DataSource dataSourceLambda = dataSource;
        area.getAreaEntities().forEach(areaEntity -> transformEntityToTable(areaEntity.getEntity(), dataSourceTablesMap, dataSourceLambda));
    }

    private void transformEntityToTable(Entity entity, Map<DataSource, List<Table>> dataSourceTablesMap, DataSource dataSource) {
        if (nonNull(entity.getSourceBySave()) && nonNull(entity.getSourceBySave())) {
            dataSource = entity.getSourceBySave();
        }

        List<Column> columnList = entity.getAttributeEntity().stream()
                .map(entityAttribute -> transformAttributeToColumn(entityAttribute.getAttribute(), entityAttribute.isRequired()))
                .collect(toList());

        Table table = new Table();
        table.setColumns(columnList);
        table.setName(entity.getName());
        entity.getRelation().forEach(relation -> transformRelationInTable(relation, table, false));

        addTableByDataSource(dataSourceTablesMap, dataSource, table);

    }

    private void transformRelationInTable(Relation relation, Table table, boolean isMain) {
        String relationType = relation.getType().toString().toUpperCase();
        //todo: в зависимости от типа связи и главная или нет простроить связь
    }

    private Column transformAttributeToColumn(Attribute attribute, boolean required) {
        return Column.builder()
                .name(attribute.getName())
                .type(getTypeByAttributeType(attribute.getAttributeType()))
                .required(required)
                .build();
    }

    private String getTypeByAttributeType(String attributeType) {
        return AttributeType.valueOf(attributeType.toUpperCase()).getJavaType();
    }

    private void addTableByDataSource(Map<DataSource, List<Table>> map, DataSource key, Table value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            List<Table> listValue = new LinkedList<>();
            listValue.add(value);
            map.put(key, listValue);
        }
    }

}
