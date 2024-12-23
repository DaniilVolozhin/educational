package ru.education.spring.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.education.spring.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Person(
                    resultSet.getLong("id"), 
                    resultSet.getString("name")
            );
        }
    }