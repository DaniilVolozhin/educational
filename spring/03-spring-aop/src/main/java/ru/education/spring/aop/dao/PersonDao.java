package ru.education.spring.aop.dao;

import ru.education.spring.aop.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
