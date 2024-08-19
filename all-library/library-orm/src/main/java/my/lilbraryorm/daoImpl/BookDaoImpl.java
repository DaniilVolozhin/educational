package my.lilbraryorm.daoImpl;

import my.lilbraryorm.dao.BookDao;
import my.lilbraryorm.entity.Book;
import my.lilbraryorm.entity.Genre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.genre = :genre", Book.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    @Override
    public Book getById(long id) {
        return em.find(Book.class, id);
    }

    @Transactional
    @Override
    public void save(Book t) {
        em.persist(t);
    }

    @Transactional
    @Override
    public Book update(Book t) {
        return em.merge(t);
    }

    @Transactional
    @Override
    public void remove(long id) {
        em.remove(em.find(Book.class, id));
    }

}
