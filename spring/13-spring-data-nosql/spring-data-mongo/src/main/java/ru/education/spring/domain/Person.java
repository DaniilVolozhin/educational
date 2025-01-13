package ru.education.spring.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "persons")
public class Person {

    @Id
    private String id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
