//package ru.education.spring.dao;
//
//import org.springframework.jdbc.core.JdbcOperations;
//import org.springframework.stereotype.Repository;
//import ru.education.spring.dao.mapper.PersonMapper;
//import ru.education.spring.domain.Person;
//
//import java.util.List;
//import java.util.Optional;
//
//@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
//@Repository
//public class PersonDaoJdbc implements PersonDao {
//    private final JdbcOperations jdbc;
//
//    public PersonDaoJdbc(JdbcOperations jdbcOperations)
//    {
//        this.jdbc = jdbcOperations;
//    }
//
//    @Override
//    public int getCount() {
//        return Optional.of(
//                jdbc.queryForObject("select count(*) from persons", Integer.class))
//                .orElseGet(() -> 0);
//    }
//
//    @Override
//    public void insert(Person person) {
//        jdbc.update("insert into persons (id, name) values (?,?)",
//                person.getId(), person.getName());
//    }
//
//    @Override
//    public Person getById(long id) {
//        return jdbc.queryForObject("select * from persons where id = ?",
//                new Object[]{id}, new PersonMapper());
//    }
//
//    @Override
//    public List<Person> getAll() {
//        return jdbc.query("select * from persons", new PersonMapper());
//    }
//}
