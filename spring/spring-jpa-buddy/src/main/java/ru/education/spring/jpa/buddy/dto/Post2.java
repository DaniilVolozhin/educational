package ru.education.spring.jpa.buddy.dto;

import lombok.Value;
import ru.education.spring.jpa.buddy.entities.User;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Post}
 */
/**
 * DTO for {@link Post2}
 */
/**
 * DTO for {@link ru.education.spring.jpa.buddy.dto.PostFromPOJO}
 */
/**
 * DTO for {@link ru.education.spring.jpa.buddy.dto.Post2Entity}
 */
@Value
public class Post2 implements Serializable {

  Long postId;
  List<UserDto> user;
  String date;

  /**
   * DTO for {@link User}
   */
  @Value
  public static class UserDto implements Serializable {

    Long id;
  }
}