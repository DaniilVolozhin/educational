package com.my.ddl.schema.controller;

import com.my.ddl.schema.dto.DataBaseDTO;
import com.my.ddl.schema.service.CreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/schema", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CreateController {

	private final CreateService createService;
	
	@PostMapping
	public void create(@RequestBody @Valid DataBaseDTO dataBaseDTO) {
		createService.create(dataBaseDTO.getDataBaseId());
	}
}
