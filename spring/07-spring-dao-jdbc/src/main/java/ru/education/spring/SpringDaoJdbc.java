package ru.education.spring;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.education.spring.dao.PersonDao;
import ru.education.spring.domain.Person;

@SpringBootApplication
public class SpringDaoJdbc {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(SpringDaoJdbc.class);

        PersonDao dao = context.getBean(PersonDao.class);

        System.out.println("Persons count: " + dao.getCount());

        dao.insert(new Person(2, "Ivan"));

        System.out.println("Persons count: " + dao.getCount());

        System.out.println("Person with id 1 : " + dao.getById(1));
        System.out.println("All person = " + dao.getAll());
        Console.main(args);
    }
}
