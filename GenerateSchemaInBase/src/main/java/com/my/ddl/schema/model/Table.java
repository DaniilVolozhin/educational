package com.my.ddl.schema.model;

import lombok.Data;

import java.util.List;

@Data
public class Table {

	private String name;
	
	private List<Column> columns;

	private List<String> oneToOne;

	private List<String> manyToOne;

	private List<String> manyToMany;

}
