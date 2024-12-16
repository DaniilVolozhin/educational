package ru.education.spring.aop.service;

import ru.education.spring.aop.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
