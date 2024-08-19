package ru.education.spring.jpa.buddy.mapper;

import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;
import ru.education.spring.jpa.buddy.dto.PostDto;
import ru.education.spring.jpa.buddy.entities.Post;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface PostMapper1 {

  Post toEntity(PostDto postDto);

  PostDto toDto(Post post);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post partialUpdate(
      PostDto postDto, @MappingTarget Post post);
}