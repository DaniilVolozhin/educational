package ru.education.spring.jpa.buddy.entities;

import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface Post1Mapper {

  Post1 toEntity(PostDto postDto);

  PostDto toDto(Post1 post1);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post1 partialUpdate(
      PostDto postDto, @MappingTarget Post1 post1);
}