package ru.education.spring.jpa.buddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringJpaBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaBuddyApplication.class, args);
	}

}
