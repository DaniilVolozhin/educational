package ru.education.spring.jpa.buddy.mapper;

import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;
import ru.education.spring.jpa.buddy.dto.PostRequest;
import ru.education.spring.jpa.buddy.entities.Post;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface PostRequestMapper {

  @Mapping(source = "userId", target = "user.id")
  Post toEntity(PostRequest postRequest);

  @Mapping(source = "user.id", target = "userId")
  PostRequest toDto(Post post);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post partialUpdate(
      PostRequest postRequest, @MappingTarget Post post);
}