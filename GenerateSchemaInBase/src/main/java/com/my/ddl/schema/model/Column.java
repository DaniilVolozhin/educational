package com.my.ddl.schema.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Column {

	private String name;
	
	private String type;

	private boolean required;

}
