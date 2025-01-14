package ru.education.spring.domain;

import lombok.Getter;

@Getter
public class Email {

    private int id;

    private String email;

    public Email(String email) {
        this.email = email;
    }

}
