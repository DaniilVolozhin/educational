package ru.education.spring.orm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "avatar_id", foreignKey = @ForeignKey(name = "fk_students_avatar_id"))
    private Avatar avatar;
    @OneToMany
    @JoinColumn(name = "students_id")
    private List<EMail> emails;
    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "students_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private List<Course> courses;
}
