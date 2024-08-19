package ru.education.spring.jpa.buddy.mapper;

import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface EntityMapper<D, E> {

  List<E> toEntity(List<D> postDto);

  List<D> toDto(List<E> post);

  E toEntity(D postDto);

  D toDto(E post);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void partialUpdate(D postDto, @MappingTarget E post);
}