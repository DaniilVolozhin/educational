package ru.education.spring.mybatis.repositories;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import ru.education.spring.mybatis.models.Avatar;
import ru.education.spring.mybatis.models.Student;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("select * from students")
//тут описывается маппинг бд и сущности и ему дается имя по которому его можно вызвать и переиспользовать для другого запроса
//через @ResultMap("id_name") в нашем случае id_name = studentAllMap
    @Results(id = "studentAllMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "avatar", column = "avatar_id", javaType = Avatar.class,
                    one = @One(select =
                                    "ru.education.spring.mybatis.repositories.AvatarRepository.getAvatarById",
                            fetchType = FetchType.EAGER
                    )
            ),
            @Result(property = "emails", column = "id", javaType = List.class,
                    many = @Many(select =
                            "ru.education.spring.mybatis.repositories.EmailRepository.getEmailsByStudentId",
                            fetchType = FetchType.EAGER
                    )
            ),
            @Result(property = "courses", column = "id", javaType = List.class,
                    many = @Many(select =
                            "ru.education.spring.mybatis.repositories.CourseRepository.getCoursesByStudentId",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<Student> findAllWithAllInfo();

    @Select("select * from students where id = #{id}")
    @ResultMap("studentAllMap")
    Student findById(long id);

    @Select("select count(*) as students_count from students")
    long getStudentsCount();

    @Insert("insert into students(name, avatar_id) values (#{name}, #{avatar.id})")
    void insert(Student student);

    @Update("update students set name = #{name} where id = #{id}")
    void updateName(Student student);

    @Delete("delete from students where id = #{id}")
    void deleteById(long id);

}
