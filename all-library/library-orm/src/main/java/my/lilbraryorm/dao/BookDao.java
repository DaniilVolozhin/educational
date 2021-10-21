package my.lilbraryorm.dao;

import my.lilbraryorm.entity.Book;
import my.lilbraryorm.entity.Genre;

import java.util.List;

public interface BookDao {
     List<Book> getAll();

     List<Book> getBooksByGenre(Genre genre);

     Book getById(long id);

     void save(Book t);

     Book update(Book t);

     void remove(long id);
}
