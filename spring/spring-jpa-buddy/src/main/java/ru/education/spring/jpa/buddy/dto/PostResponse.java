package ru.education.spring.jpa.buddy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.education.spring.jpa.buddy.entities.Post;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse implements Serializable {

  private Long postId;
  private String email;
  private String date;
  private Long userId;
}