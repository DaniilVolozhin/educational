package ru.education.spring.jpa.buddy.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "post_2_entity")
public class Post2Entity {

  @Column(name = "post_id")
  private Long postId;

  @OneToMany(mappedBy = "post2Entity", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<User> user = new LinkedHashSet<>();

  @Column(name = "date")
  private String date;

}