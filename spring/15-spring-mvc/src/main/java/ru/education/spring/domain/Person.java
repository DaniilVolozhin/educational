package ru.education.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("person")
@Getter
@Setter
@AllArgsConstructor
public class Person {

    @Id
    private int id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
