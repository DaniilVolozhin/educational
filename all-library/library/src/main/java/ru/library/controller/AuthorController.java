package ru.library.controller;

import ru.library.daoJdbc.AuthorsDaoJdbc;
import ru.library.domain.Author;

import java.util.List;

public class AuthorController {
    private final AuthorsDaoJdbc authorsDaoJdbc;

    public AuthorController(AuthorsDaoJdbc authorsDaoJdbc) {
        this.authorsDaoJdbc = authorsDaoJdbc;
    }

    public List<Author> get() {
        return authorsDaoJdbc.getAll();
    }

    public Author getById(long id) {
        return authorsDaoJdbc.getById(id);
    }
}
