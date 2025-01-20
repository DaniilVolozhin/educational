package ru.education.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.education.spring.reactor.FluxService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

        FluxService service = context.getBean(FluxService.class);

        System.out.println("-------------------------------");

//        while (true)
        service.printHello("Ivan");
    }
}


