package ru.education.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.education.spring.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("дао для работы с person должно")
@JdbcTest
@Import(PersonDaoNamedJdbc.class)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
//или на методе
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class DirtiesContextPersonDaoNamedJdbcTest {

    @Autowired
    private PersonDaoNamedJdbc personDaoNamedJdbc;

    @Test
//позволяет очистить контекст после теста который его изменил, бд или бины
    @DisplayName("возвращать ожидаемое количество persons в бд")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void count() {
        int count = personDaoNamedJdbc.getCount();
        int expectedPersonCount = 2;
        assertThat(count).isEqualTo(expectedPersonCount);
    }

    @Test
    @DisplayName("добавлять person в бд")
    void insert() {
        int id = 3;
        Person expected = new Person(id, "Vasya");
        personDaoNamedJdbc.insert(expected);
        assertThat(personDaoNamedJdbc.getById(id)).isEqualTo(expected);
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