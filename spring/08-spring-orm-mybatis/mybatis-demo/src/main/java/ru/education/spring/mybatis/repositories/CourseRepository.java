package ru.education.spring.mybatis.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.education.spring.mybatis.models.Course;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("select * from student_courses sc left join courses c on sc.course_id = c.id where sc.student_id = #{studentId}")
    List<Course> getCoursesByStudentId(long studentId);

}
