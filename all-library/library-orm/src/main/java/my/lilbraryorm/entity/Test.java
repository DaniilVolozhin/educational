package my.lilbraryorm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String test;

    public Test() {
    }

    public Test(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", test='" + test + '\'' +
                '}';
    }

    public Test(String test, long id) {
        this.test = test;
        this.id = id;
    }
//    private Date date;
//
//    @PrePersist
//    private void setDate() {
//        date = new Date();
//    }
}
