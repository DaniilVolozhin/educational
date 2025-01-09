package ru.education.spring.data.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.education.spring.data.jpa.domain.Email;
import ru.education.spring.data.jpa.domain.Person;
import ru.education.spring.data.jpa.repository.EmailRepository;
import ru.education.spring.data.jpa.repository.PersonRepository;

import javax.annotation.PostConstruct;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmailRepository emailRepository;

    @PostConstruct
    public void init() {
        Email email1 = new Email("email1");
        emailRepository.save(email1);

        personRepository.save(new Person("Pushkin", email1));

        System.out.println("FIND PERSON: " + personRepository.findAll());
        System.out.println("FIND EMAIL: " + emailRepository.findAllByEmail("email1"));
        System.out.println("FIND PERSON BY EMAIL: " +
                personRepository.findAllByEmail_Email("email1"));
        System.out.println("FIND EMAIL WITH QUERY: " +
                emailRepository.findAllByEmailQuery("email1"));
    }
}
