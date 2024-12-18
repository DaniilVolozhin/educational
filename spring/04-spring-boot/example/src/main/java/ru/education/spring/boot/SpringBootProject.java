package ru.education.spring.boot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.education.spring.boot.configs.AppProps;
import ru.education.spring.boot.service.WelcomeService;


@RequiredArgsConstructor
@SpringBootApplication
@EnableConfigurationProperties(AppProps.class)
public class SpringBootProject {

    /*
     *  todo: поправить проект со спринг стартером
     */
    public static void main(String[] args) {
        var context = SpringApplication.run(SpringBootProject.class, args);
        var welcome = context.getBean(WelcomeService.class);
        welcome.sayHello();
    }

}
