package ru.education.spring.repostory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.education.spring.domain.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
