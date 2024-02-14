package com.my.ddl.schema.service;

import com.my.ddl.schema.model.Table;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateService {

	private final TransformService transformService;
	private final GenerateService generateService;

	@Qualifier("settings")
	private final Map<String, String> settings;

	public void create(UUID dbId) {
		List<Table> tableList = transformService.findProjectAndTransform(dbId);
		generateService.execute(tableList, settings);
	}

}
