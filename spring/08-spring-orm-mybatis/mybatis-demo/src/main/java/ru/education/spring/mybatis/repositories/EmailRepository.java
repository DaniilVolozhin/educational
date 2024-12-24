package ru.education.spring.mybatis.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.education.spring.mybatis.models.EMail;

import java.util.List;

@Mapper
public interface EmailRepository {

    @Select("select * from emails where student_id = #{studentId}")
    List<EMail> getEmailsByStudentId(long studentId);
}
