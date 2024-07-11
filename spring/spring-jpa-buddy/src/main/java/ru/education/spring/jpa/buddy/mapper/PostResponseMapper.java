package ru.education.spring.jpa.buddy.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.education.spring.jpa.buddy.entities.Post;
import ru.education.spring.jpa.buddy.dto.PostResponse;

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