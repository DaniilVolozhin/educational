package ru.education.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.education.spring.data.jpa.domain.Email;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {

    Optional<Email> findAllByEmail(String email);

    @Query("select e from Email e where e.email = :email")
    Optional<Email> findAllByEmailQuery(@Param("email") String email);
}
