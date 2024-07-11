package ru.education.spring.jpa.buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.spring.jpa.buddy.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}