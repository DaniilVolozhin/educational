package ru.education.spring.jpa.buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.spring.jpa.buddy.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}