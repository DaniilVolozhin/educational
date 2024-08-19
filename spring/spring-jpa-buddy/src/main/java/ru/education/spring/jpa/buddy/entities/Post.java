package ru.education.spring.jpa.buddy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long postId;

  @Column(name = "date")
  private String date;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "text")
  private String text;

  @Column(name = "email")
  private String email;

}