package my.lilbraryorm.entity;

import javax.persistence.*;
import java.util.Date;

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
