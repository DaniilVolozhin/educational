package ru.education.example.spring.test.externalConfig;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import ru.education.example.spring.test.family.FamilyMember;
import ru.education.example.spring.test.family.parents.Father;
import ru.education.example.spring.test.family.pets.Dog;

@ComponentScan(value = "ru.education.example.spring.test.family",
        excludeFilters =
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Dog.class))
@SpringBootConfiguration
public class ExternalSpringBootTestConfiguration {

    @Bean
    public FamilyMember father() {
        return new Father();
    }
}
