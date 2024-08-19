package ru.education.spring.jpa.buddy.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "post_2_entity_id")
  private ru.education.spring.jpa.buddy.dto.Post2Entity post2Entity;

}