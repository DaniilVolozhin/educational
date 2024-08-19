package ru.education.spring.jpa.buddy.mapper;

import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;
import ru.education.spring.jpa.buddy.dto.PostResponse;
import ru.education.spring.jpa.buddy.entities.Post;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface PostResponseMapper {

  @Mapping(source = "userId", target = "user.id")
  Post toEntity(PostResponse postResponse);

  @Mapping(source = "user.id", target = "userId")
  PostResponse toDto(Post post);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post partialUpdate(
      PostResponse postResponse, @MappingTarget Post post);
}