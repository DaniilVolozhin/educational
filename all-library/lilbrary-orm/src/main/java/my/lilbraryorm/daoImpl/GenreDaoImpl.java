package my.lilbraryorm.daoImpl;

import my.lilbraryorm.dao.GenreDao;
import my.lilbraryorm.entity.Genre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery("from Genre", Genre.class);
        return query.getResultList();
    }

    @Override
    public Genre getById(long id) {
        return em.find(Genre.class, id);
    }

    @Transactional
    @Override
    public void save(Genre genre) {
        em.persist(genre);
    }

    @Transactional
    @Override
    public Genre update(Genre genre) {
        return em.merge(genre);
    }

    @Transactional
    @Override
    public void remove(long id) {
        em.remove(em.find(Genre.class, id));
    }

    @Override
    @Transactional
    public void detach(Genre genre) {
        em.detach(genre);
    }
}
