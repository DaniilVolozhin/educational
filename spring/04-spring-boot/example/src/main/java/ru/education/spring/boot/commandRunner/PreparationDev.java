package ru.education.spring.boot.commandRunner;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.education.spring.boot.starter.Messager;

import java.util.Arrays;


@Component
@RequiredArgsConstructor
public class PreparationDev implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(PreparationDev.class);

    private Messager messager;

    @Override
    public void run(String... args) {
        logger.info("DEV mode!!! Что-то настравиваем и подготавливаем, параметры: {} ", Arrays.toString(args));
        logger.info("message from Messager:{}", messager.sayMessage());
        //args парметры, котрые могут быть переданы в Main
    }
}
