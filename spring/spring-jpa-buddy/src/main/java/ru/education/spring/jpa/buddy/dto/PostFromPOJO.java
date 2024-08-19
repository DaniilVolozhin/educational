package ru.education.spring.jpa.buddy.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.education.spring.jpa.buddy.entities.User;

@Getter
@Setter
@Entity
@Table(name = "post_from_pojo")
public class PostFromPOJO {

  @Column(name = "post_id")
  private Long postId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "date")
  private String date;

}