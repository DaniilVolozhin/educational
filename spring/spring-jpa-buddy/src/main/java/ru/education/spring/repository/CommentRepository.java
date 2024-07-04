package ru.education.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.spring.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}