package ru.education.spring.orm.jpql.repositories;


import ru.education.spring.orm.jpql.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryJpa {
    Student save(Student student);
    Optional<Student> findById(long id);

    List<Student> findAll();
    List<Student> findByName(String name);

    void updateNameById(long id, String name);
    void deleteById(long id);
}
