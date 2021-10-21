package com.my.ddl.schema.controller;

import com.my.ddl.schema.service.SchemaCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.my.ddl.schema.dto.SchemaUUIDDTO;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/schema", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SchemaController {

	private final SchemaCreateService schemaCreateService;
	
	@PostMapping
	public void create(@RequestBody @Valid SchemaUUIDDTO schemaUUIDDTO) {
		schemaCreateService.create(schemaUUIDDTO.getSchemaId());
	}

}
