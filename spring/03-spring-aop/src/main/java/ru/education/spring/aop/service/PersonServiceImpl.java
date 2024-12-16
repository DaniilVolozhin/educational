package ru.education.spring.aop.service;

import org.springframework.stereotype.Service;
import ru.education.spring.aop.dao.PersonDao;
import ru.education.spring.aop.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
