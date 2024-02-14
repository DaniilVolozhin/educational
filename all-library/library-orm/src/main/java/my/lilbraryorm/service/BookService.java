package my.lilbraryorm.service;

import my.lilbraryorm.dao.BookDao;
import my.lilbraryorm.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public Book getById(long id) {
        return bookDao.getById(id);
    }

    public void save(Book book) {
        bookDao.save(book);
    }

    public Book update(Book book) {
        return bookDao.update(book);
    }

    public void remove(long id) {
        bookDao.remove(id);
    }
}
