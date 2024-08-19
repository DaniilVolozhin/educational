package ru.education.spring.jpa.buddy.dto;

import lombok.Value;
import ru.education.spring.jpa.buddy.entities.User;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
/**
 * DTO for {@link Post2}
 */
/**
 * DTO for {@link ru.education.spring.jpa.buddy.dto.PostFromPOJO}
 */
@Value
public class PostDto implements Serializable {

  Long postId;
  UserDto user;
  String date;

  /**
   * DTO for {@link User}
   */
  @Value
  public static class UserDto implements Serializable {

    Long id;
  }
}