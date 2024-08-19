package ru.education.spring.jpa.buddy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto1 implements Serializable {

  private Long postId;
  private String date;
  private String text;
  private String email;
}