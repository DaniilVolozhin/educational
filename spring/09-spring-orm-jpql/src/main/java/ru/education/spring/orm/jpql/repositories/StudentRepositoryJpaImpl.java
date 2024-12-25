package ru.education.spring.orm.jpql.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.education.spring.orm.jpql.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
@RequiredArgsConstructor
public class StudentRepositoryJpaImpl implements StudentRepositoryJpa {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Student> findById(long id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query =
                entityManager.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s where s.name = :name", Student.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Student save(Student student) {
        if (student.getId() == 0) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
        return student;
    }

    @Override
    public void updateNameById(long id, String name) {

    }

    @Override
    public void deleteById(long id) {
    }

}
