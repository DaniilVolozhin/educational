package ru.education.spring.xml.dao;

import ru.education.spring.xml.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
