package ru.education.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.education.spring.domain.Person;
import ru.education.spring.exception.NotFoundException;
import ru.education.spring.repostory.PersonRepository;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/person/{id}")
    public Person getById(
            @PathVariable(value = "id") int idPathVariable
    ) {
        System.out.println("idPathVariable: " + idPathVariable);
        return repository.findById(idPathVariable).orElseThrow(NotFoundException::new);
    }

    @GetMapping(value = "/person/id")
    public Person getByIdRequestParam(
            @RequestParam(name = "id") int idRequestParam
    ) {
        System.out.println("idRequestParam: " + idRequestParam);
        return repository.findById(idRequestParam).orElseThrow(NotFoundException::new);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception e) {
        return ResponseEntity.badRequest().body("Not found");
    }
}

