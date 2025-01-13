package ru.education.spring.repostory;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;
import ru.education.spring.domain.Person;

@Repository
public interface PersonRepository extends KeyValueRepository<Person, Integer> {
}
