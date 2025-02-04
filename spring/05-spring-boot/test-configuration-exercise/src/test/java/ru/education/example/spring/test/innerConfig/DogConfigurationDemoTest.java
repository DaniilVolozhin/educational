package ru.education.example.spring.test.innerConfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.education.example.spring.test.family.FamilyMember;
import ru.education.example.spring.test.family.pets.Dog;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("В NestedConfigurationDemoTest семья должна ")
@SpringBootTest
public class DogConfigurationDemoTest {

    @Configuration
    static class TestConfiguration {
        @Bean
        public Dog dog() {
            return new Dog();
        }
    }

//    or

//    @ComponentScan("ru.education.example.spring.test.family.pets")
//    @Configuration
//    static class TestConfiguration {}

//    or

//    only with "dog" -> @Component("dog")
//    @Import(Dog.class)
//    @Configuration
//    static class TestConfiguration {}

    @Autowired
    private Map<String, FamilyMember> family;

    @DisplayName(" содержать только собаку ")
    @Test
    void shouldContainOnlyDog() {
        assertThat(family).containsOnlyKeys("dog");
    }

}
