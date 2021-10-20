package my.lilbraryorm.dao;

import my.lilbraryorm.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAll();
    Genre getById(long id);

    void save(Genre t);

    Genre update(Genre t);

    void remove(long id);

    void detach(Genre genre);
}
