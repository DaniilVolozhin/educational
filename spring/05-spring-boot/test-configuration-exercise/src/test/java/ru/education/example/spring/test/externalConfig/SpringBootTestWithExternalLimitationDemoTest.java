package ru.education.example.spring.test.externalConfig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.education.example.spring.test.family.FamilyMember;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("В SpringBootTestWithExternalLimitationDemoTest семья должна ")
@SpringBootTest
public class SpringBootTestWithExternalLimitationDemoTest {

    @Autowired
    private Map<String, FamilyMember> family;

    @DisplayName(" содержать маму, папу и сына")
    @Test
    void shouldContainAllFamilyExceptFather() {
        assertThat(family).containsOnlyKeys("mother", "father", "son");
    }

}
