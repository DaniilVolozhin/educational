package ru.education.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.education.spring.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("дао для работы с person должно")
@JdbcTest
@Import(PersonDaoNamedJdbc.class)
class PersonDaoNamedJdbcTest {

    @Autowired
    private PersonDaoNamedJdbc personDaoNamedJdbc;

    @Test
    @DisplayName("возвращать ожидаемое количество persons в бд")
    void count() {
        int count = personDaoNamedJdbc.getCount();
        int expectedPersonCount = 2;
        assertThat(count).isEqualTo(expectedPersonCount);
    }

//    @Test
//    @DisplayName("добавлять person в бд")
//    void insert() {
//        int id = 3;
//        Person expected = new Person(id, "Vasya");
//        personDaoNamedJdbc.insert(expected);
//        assertThat(personDaoNamedJdbc.getById(id)).isEqualTo(expected);
//    }

    @Test
    @DisplayName("добавлять person в бд")
    void insert() {
        int expectedNewId = 3;
        Person expected = new Person("Vasya");
        long id = personDaoNamedJdbc.insert(expected);
        assertThat(id).isEqualTo(expectedNewId);
        expected.setId(id);
        assertThat(personDaoNamedJdbc.getById(expectedNewId)).isEqualTo(expected);
    }

    @Test
    @DisplayName("возвращать ожидаемого person по его id")
    void getById() {
        long nastyaId = 1L;
        String nastyaName = "Nastya";
        Person expected = personDaoNamedJdbc.getById(nastyaId);
        assertThat(expected)
                .hasFieldOrPropertyWithValue("id", nastyaId)
                .hasFieldOrPropertyWithValue("name", nastyaName);
    }
}