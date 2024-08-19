package ru.education.spring.jpa.buddy.mapper;

import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;
import ru.education.spring.jpa.buddy.dto.PostDto;
import ru.education.spring.jpa.buddy.entities.Post;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface PostMapper {

  Post toEntity(PostDto postDto);

  PostDto toDto(Post post);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post partialUpdate(PostDto postDto, @MappingTarget Post post);

  Set<Post> toEntity(Set<PostDto> postDto);

  Set<PostDto> toDto(Set<Post> post);
}