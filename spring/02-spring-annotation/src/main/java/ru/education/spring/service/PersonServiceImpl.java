package ru.education.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.education.spring.dao.PersonDao;
import ru.education.spring.domain.Person;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
