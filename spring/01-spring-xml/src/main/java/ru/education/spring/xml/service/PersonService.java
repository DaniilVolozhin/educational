package ru.education.spring.xml.service;

import ru.education.spring.xml.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
