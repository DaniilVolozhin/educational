package com.my.ddl.schema.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = "classpath:/hibernate-config.properties")
@RequiredArgsConstructor
public class HibernateConfig {

	private final Environment env;

	@Bean
	public Map<String, String> settings(/*DataSource dataSource*/) {
		Map<String, String> settings = new HashMap<>();

		// Здесь мне нужно из dataSource получить параметры, создать эту памму что бы передать ее в MetadataSource объект hibernate

//		settings.put("hibernate.connection.driver_class", dataSource.getDataSourceType().get);
//		settings.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//		settings.put("hibernate.connection.url", );
//		settings.put("hibernate.connection.username", );
//		settings.put("hibernate.connection.password", );


		settings.put("hibernate.connection.driver_class", env.getProperty("hibernate.connection.driver_class"));
		settings.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		settings.put("hibernate.connection.url", env.getProperty("hibernate.connection.url"));
		settings.put("hibernate.connection.username", env.getProperty("hibernate.connection.username"));
		settings.put("hibernate.connection.password", env.getProperty("hibernate.connection.password"));

		return settings;
	}
}

