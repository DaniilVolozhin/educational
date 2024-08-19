package ru.education.spring.jpa.buddy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
/**
 * DTO for {@link Post1}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Serializable {

  private Long postId;
  private String date;
  private Long userId;
  private String text;
  private String email;
}