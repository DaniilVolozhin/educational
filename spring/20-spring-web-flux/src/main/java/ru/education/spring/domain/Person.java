package ru.education.spring.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Person {

    @Id
    private String id;

    @JsonProperty("name")
    @Field("name")
    private String lastName;

    private int age;

    public Person(String lastName) {
        this.lastName = lastName;
    }

    public Person(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }
}
