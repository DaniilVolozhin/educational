package ru.library.daoJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import ru.library.dao.AuthorsDao;
import ru.library.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class AuthorsDaoJdbc implements AuthorsDao {

    @Autowired
    private NamedParameterJdbcOperations jdbc;

    private AuthorMapper mapper = new AuthorMapper();

    @Override
    public Author getById(long id) {
        final HashMap<String, Long> map = new HashMap<>();
        map.put("id", id);
        return jdbc.queryForObject("select * from Author", map, mapper);
    }

    @Override
    public List<Author> getAll() {
        return null;
    }


    private static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            Author author = new Author();
            author.setId(resultSet.getInt("id"));
            author.setLastName(resultSet.getString("lastName"));
            author.setMiddleName(resultSet.getString("middleName"));
            author.setSurName(resultSet.getString("surName"));
            return author;
        }
    }
}
