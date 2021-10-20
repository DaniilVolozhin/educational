package ru.library.dao;

import ru.library.domain.Author;

import java.util.List;

public interface AuthorsDao {
    Author getById(long id);
    List<Author> getAll();

/*
    void updateSurName(long id, String surName);
    void updateLastName(long id, String lastName);
    void updateMiddleName(long id, String middleName);
    void updateBooks(long id, String books);

    void save(Author t);

    void delete(long id);
*/
}
