package ru.education.spring.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.education.spring.domain.Person;
import ru.education.spring.repository.PersonRepository;

@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/person")
    public Flux<Person> all() {
        return repository.findAll();
    }

    @GetMapping("/person/{id}")
    public Mono<ResponseEntity<Person>> byId(@PathVariable("id") String id) {
        return repository.findById(id)
                .map(this::serviceMethodCapitalize)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.status(404).build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    //метод без side эффекта
    public Person serviceMethodCapitalize(Person person) {
        return new Person(
                person.getId(),
                person.getLastName().toUpperCase(),
                person.getAge()
        );
    }

    @GetMapping("/person")
    public Flux<ResponseEntity<Person>> findByName(@RequestParam("name") String name) {
        return repository.findAllByLastName(name)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.status(404).build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/person")
    public Flux<Person> findByAge(@RequestParam("age") int age) {
        return repository.findAllByAge(age);
    }

    @PostMapping("/person")
    public Mono<Person> save(@RequestBody Mono<Person> dto) {
        return repository.save(dto);
    }

    @GetMapping("/person/find")
    public Flux<Person> byName(@RequestParam("name") String name) {
        return repository.findAllByLastName(name);
    }
}
