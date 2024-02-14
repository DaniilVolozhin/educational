package com.my.ddl.schema.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = "classpath:/application.properties")
@RequiredArgsConstructor
public class DataBaseConfiguration {

	private final Environment env;

	@Bean
	public Map<String, String> settings() {
		Map<String, String> settings = new HashMap<>();

		settings.put("hibernate.connection.driver_class", env.getProperty("hibernate.connection.driver_class"));
		settings.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		settings.put("hibernate.connection.url", env.getProperty("hibernate.connection.url"));
		settings.put("hibernate.connection.username", env.getProperty("hibernate.connection.username"));
		settings.put("hibernate.connection.password", env.getProperty("hibernate.connection.password"));

		return settings;
	}
}

