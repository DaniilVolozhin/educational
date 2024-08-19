package my.lilbraryorm.daoImpl;

import my.lilbraryorm.dao.CommentDao;
import my.lilbraryorm.entity.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentDaoImpl implements CommentDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(Comment t) {
        em.persist(t);
    }

    @Transactional
    @Override
    public Comment update(Comment t) {
        return em.merge(t);
    }

    @Transactional
    @Override
    public void remove(long id) {
        em.remove(em.find(Comment.class, id));
    }
}
