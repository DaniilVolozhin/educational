package ru.education.spring.repostory;

import ru.education.spring.domain.Email;

import java.util.List;

public interface EmailRepository {
    List<Email> findAll();

    Email save(Email email);
}
