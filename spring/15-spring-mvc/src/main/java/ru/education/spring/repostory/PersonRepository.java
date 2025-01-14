package ru.education.spring.repostory;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.education.spring.domain.Person;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

    List<Person> findAll();
}
