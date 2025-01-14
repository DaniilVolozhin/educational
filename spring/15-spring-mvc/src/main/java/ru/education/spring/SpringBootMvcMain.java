package ru.education.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import ru.education.spring.domain.Person;
import ru.education.spring.repostory.PersonRepository;

import javax.annotation.PostConstruct;

@EnableMapRepositories
@SpringBootApplication
public class SpringBootMvcMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcMain.class);
    }

    @Autowired
    private PersonRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new Person("Pushkin"));
    }
}
