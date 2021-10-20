package my.lilbraryorm.daoImpl;

import my.lilbraryorm.dao.AuthorDao;
import my.lilbraryorm.entity.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Author> getAuthorsByBookId(long id) {
        Query query = em.createQuery("Select a from Author as a, IN(a.books) as b where b.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery("from Author", Author.class);
        return query.getResultList();
    }

    @Override
    public Author getById(long id) {
        return em.find(Author.class, id);
    }

    @Transactional
    @Override
    public void save(Author t) {
        em.persist(t);
    }

    @Transactional
    @Override
    public Author update(Author t) {
        return em.merge(t);
    }

    @Transactional
    @Override
    public void remove(long id) {
        em.remove(em.find(Author.class, id));
    }
}
