package ru.education.spring.xml.service;

import ru.education.spring.xml.dao.PersonDao;
import ru.education.spring.xml.domain.Person;

public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
