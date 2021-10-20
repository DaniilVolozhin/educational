package my.lilbraryorm.dao;

import my.lilbraryorm.entity.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getAll();

    List<Author> getAuthorsByBookId(long id);

    Author getById(long id);

    void save(Author t);

    Author update(Author t);

    void remove(long id);
}
