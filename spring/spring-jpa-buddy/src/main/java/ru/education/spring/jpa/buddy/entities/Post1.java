package ru.education.spring.jpa.buddy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post_1")
public class Post1 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "post_id")
  private Long postId;

  @Column(name = "date")
  private String date;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "text")
  private String text;

  @Column(name = "email")
  private String email;

}