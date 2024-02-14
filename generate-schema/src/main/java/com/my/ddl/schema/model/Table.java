package com.my.ddl.schema.model;

import lombok.Data;

import java.util.List;

@Data
public class Table {

	private String name;
	
	private List<Column> columns;
}
