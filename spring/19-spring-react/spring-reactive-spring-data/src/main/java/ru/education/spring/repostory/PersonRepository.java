package ru.education.spring.repostory;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.education.spring.domain.Person;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
    Flux<Person> findByName(String name);

    @Query("{ 'name': ?0 }")
    Mono<Person> findFirstByName(String name);
}
