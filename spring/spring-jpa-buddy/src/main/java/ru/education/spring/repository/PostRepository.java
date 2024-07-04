package ru.education.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.spring.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}