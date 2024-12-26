package ru.education.spring.orm.jpql.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.education.spring.orm.jpql.models.Student;

import javax.persistence.*;
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

    public List<Student> findAllWithEntityGraph() {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("avatar_fetch_graph");
        TypedQuery<Student> query =
                entityManager.createQuery("select s from Student s", Student.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }

    public List<Student> findAllWithJoinFetchAndEntityGraph() {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("avatar_fetch_graph");
        TypedQuery<Student> query =
                entityManager.createQuery("select s from Student s join fetch s.emails", Student.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
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
        Query query = entityManager.createQuery(
                        "update Student s set s.name = :name where s.id = :id");
        query.setParameter("id", id);
        query.setParameter("name", name);
        query.executeUpdate();
    }

    @Override
    public void deleteById(long id) {
        Query query = entityManager.createQuery(
                "delete from Student s where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
