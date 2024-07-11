package ru.education.spring.jpa.buddy.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

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