package ru.education.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import ru.education.spring.domain.Email;
import ru.education.spring.domain.Person;
import ru.education.spring.repostory.EmailRepository;
import ru.education.spring.repostory.PersonRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMapRepositories
public class SpringBootDataKeyValueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataKeyValueApplication.class);
    }

    @Autowired
    private PersonRepository repository;

    @Autowired
    private EmailRepository emailRepository;

    @PostConstruct
    public void init() {
        emailRepository.save(new Email("email1"));

        System.out.println("emailRepository = " + emailRepository.findAll());

        repository.save(new Person("Pushkin"));

        System.out.println(repository.findAll());
    }
}
