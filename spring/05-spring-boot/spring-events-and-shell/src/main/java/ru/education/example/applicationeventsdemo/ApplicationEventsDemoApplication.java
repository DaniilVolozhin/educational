package ru.education.example.applicationeventsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@SpringBootApplication
public class ApplicationEventsDemoApplication {

//	позволяет переопределить обработчик для обработки событий лисенерами
//	в этом случае асинхронная паралельная обработка событий
//	по умолчанию обработка последовательная
	//@Bean @Primary
//	или
//	@Bean(name = "applicationEventMulticaster")
	public ApplicationEventMulticaster applicationEventMulticaster() {
		SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
		eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return eventMulticaster;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEventsDemoApplication.class, args);
	}

}
