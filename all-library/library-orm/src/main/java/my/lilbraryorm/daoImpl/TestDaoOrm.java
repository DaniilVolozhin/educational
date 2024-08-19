package my.lilbraryorm.daoImpl;

import my.lilbraryorm.entity.Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TestDaoOrm extends SkeletonDaoOrm<Test> {
    @Transactional
    @Override
    public List<Test> get() {
        TypedQuery<Test> query = em.createQuery("from Test", Test.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Test getById(long id) {
        TypedQuery<Test> query = em.createQuery("from Test where id = :id", Test.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
