package ru.education.spring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("email")
public class Email {

    @Id
    private int id;

    private String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
