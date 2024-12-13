package ru.education.spring.dao;

import ru.education.spring.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
