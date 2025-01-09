package ru.education.spring.data.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToOne
    private Email email;

    public Person(String name, Email email) {
        this.name = name;
        this.email = email;
    }
}
