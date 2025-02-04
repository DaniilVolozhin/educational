package ru.education.spring.aop.dao;

import org.springframework.stereotype.Repository;
import ru.education.spring.aop.domain.Person;

@Repository
public class PersonDaoSimple implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
