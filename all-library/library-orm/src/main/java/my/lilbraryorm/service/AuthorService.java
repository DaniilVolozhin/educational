package my.lilbraryorm.service;

import my.lilbraryorm.dao.AuthorDao;
import my.lilbraryorm.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public List<Author> getAuthorsByBookId(long id) {
        return authorDao.getAuthorsByBookId(id);
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }

    public Author getById(long id) {
        return authorDao.getById(id);
    }

    public void save(Author author) {
        authorDao.save(author);
    }

    public Author update(Author author) {
       return authorDao.update(author);
    }

    public void remove(long id) {
        authorDao.remove(id);
    }
}
