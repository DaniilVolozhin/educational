package ru.education.spring;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.education.spring.domain.Person;
import ru.education.spring.repostory.PersonRepository;

@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class SpringBootDataMangoApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(SpringBootDataMangoApplication.class);

        PersonRepository repository = context.getBean(PersonRepository.class);

        repository.save(new Person("Dostoevsky"));

        System.out.println("\n\n\n----------------------------------------------\n\n");
        System.out.println("Авторы в БД:");
        repository.findAll().forEach(p -> System.out.println(p.getName()));
        System.out.println("\n\n----------------------------------------------\n\n\n");
    }
}
