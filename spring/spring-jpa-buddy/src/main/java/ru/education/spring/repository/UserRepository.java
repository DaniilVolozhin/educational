package ru.education.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}