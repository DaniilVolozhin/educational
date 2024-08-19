package ru.education.spring.jpa.buddy.entities;

import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface PostMapper2 {

  Post toEntity(PostDto1 postDto1);

  PostDto1 toDto(Post post);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post partialUpdate(
      PostDto1 postDto1, @MappingTarget Post post);
}