package com.my.ddl.schema.service;

import com.my.ddl.schema.model.Table;

import java.util.List;
import java.util.Map;

public interface SchemaOperation {
	
	void execute(List<Table> table, Map<String, String> settings);
}
