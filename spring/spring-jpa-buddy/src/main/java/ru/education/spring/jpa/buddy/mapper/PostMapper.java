package ru.education.spring.jpa.buddy.mapper;

import java.util.Set;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.education.spring.jpa.buddy.entities.Post;
import ru.education.spring.jpa.buddy.dto.PostDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface PostMapper {

  Post toEntity(PostDto postDto);

  PostDto toDto(Post post);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Post partialUpdate(PostDto postDto, @MappingTarget Post post);

  Set<Post> toEntity(Set<PostDto> postDto);

  Set<PostDto> toDto(Set<Post> post);
}