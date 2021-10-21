package com.my.ddl.schema.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.my.ddl.schema.entity.DataSource;
import com.my.ddl.schema.model.Table;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchemaCreateService {

	private final TransformService transformService;
	private final SchemaOperation schemaGenerateSchemaOperation;

	@Qualifier("settings")
	private final Map<String, String> settings;

	public void create(UUID projectId) {
		Map<DataSource, List<Table>> dataSourceTablesMap = transformService.findProjectAndTransform(projectId);
		dataSourceTablesMap.forEach((dataSource, tables) -> schemaGenerateSchemaOperation.execute(tables, settings));
	}

}
