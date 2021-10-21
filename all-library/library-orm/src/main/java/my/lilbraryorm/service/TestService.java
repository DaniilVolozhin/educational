package my.lilbraryorm.service;

import my.lilbraryorm.daoImpl.TestDaoOrm;
import my.lilbraryorm.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestDaoOrm testDaoOrm;

    public List<Test> get() {
        return testDaoOrm.get();
    }

    public Test getById(long id) {
        return testDaoOrm.getById(id);
    }

    public void save(Test test) {
        testDaoOrm.save(test);
    }

    public Test update(Test test) {
        return testDaoOrm.update(test);
    }

    public void remove(long id) {
        testDaoOrm.remove(id);
    }
}
