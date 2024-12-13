package ru.education.spring.service;

import ru.education.spring.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
