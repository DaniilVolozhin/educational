package ru.education.spring.jpa.buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.spring.jpa.buddy.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}