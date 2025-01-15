package ru.education.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.education.spring.domain.Person;
import ru.education.spring.repostory.PersonRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootMvcViewMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcViewMain.class);
    }

    //Чтобы не усложнять пример, делать так нельзя :)
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new Person("Pushkin"));
        repository.save(new Person("Lermontov"));
    }
}
