package ru.education.spring.mybatis.repositories;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.education.spring.mybatis.models.Avatar;

@Mapper
public interface AvatarRepository {
    @Select("select * from avatars where id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "photoUrl", column = "photo_url")
    })
    Avatar getAvatarById(long id);

}
