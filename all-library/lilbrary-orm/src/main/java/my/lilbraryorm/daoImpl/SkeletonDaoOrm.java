package my.lilbraryorm.daoImpl;

import my.lilbraryorm.dao.SkeletonDao;
import my.lilbraryorm.entity.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class SkeletonDaoOrm<T> implements SkeletonDao<T> {
    @PersistenceContext
    protected EntityManager em;

    @Override
    public abstract List<T> get();

    @Override
    public abstract T getById(long id);

    @Transactional
    @Override
    public void save(T t) {
        em.persist(t);
    }

    @Transactional
    @Override
    public T update(T t) {
        return em.merge(t);
    }

    @Transactional
    @Override
    public void remove(long id) {
        em.remove(em.find(Test.class, id));
    }
}
