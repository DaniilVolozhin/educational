package ru.education.spring.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.education.spring.dao.mapper.PersonMapper;
import ru.education.spring.domain.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
@RequiredArgsConstructor
public class PersonDaoNamedJdbc implements PersonDao {
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public int getCount() {
        return Optional.of(
                jdbc.getJdbcOperations()
                        .queryForObject("select count(*) from persons", Integer.class))
                .orElseGet(() -> 0);
    }

//with bigint
//    @Override
//    public void insert(Person person) {
//        Map<String, Object> params = new HashMap<>(2);
//        params.put("id", person.getId());
//        params.put("name", person.getName());
//        jdbc.update("insert into persons (id, name) values (:id,:name)", params);
//    }

//    with bigserial
    @Override
    public long insert(Person person) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", person.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update("insert into persons (name) values (:name)", params, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public Person getById(long id) {
        Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.queryForObject(
                "select * from persons where id = :id", params, new PersonMapper()
        );
    }

    @Override
    public List<Person> getAll() {
        return jdbc.query("select * from persons", new PersonMapper());
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from persons where id = :id", Map.of("id", id));
    }
}
