package ru.education.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.education.spring.domain.Person;
import ru.education.spring.service.PersonService;

@ComponentScan(basePackages = "ru.education.spring")
public class MainWithRefreshContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(MainWithRefreshContext.class);
        context.refresh();

        PersonService service = context.getBean(PersonService.class);

        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
