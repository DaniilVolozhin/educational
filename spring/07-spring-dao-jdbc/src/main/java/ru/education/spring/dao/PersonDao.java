package ru.education.spring.dao;

import ru.education.spring.domain.Person;

import java.util.List;

public interface PersonDao {

    int getCount();

    long insert(Person person);

    Person getById(long id);

    List<Person> getAll();

    void deleteById(long id);
}
