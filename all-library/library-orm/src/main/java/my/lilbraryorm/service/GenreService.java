package my.lilbraryorm.service;

import my.lilbraryorm.dao.GenreDao;
import my.lilbraryorm.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreDao genreDao;

    public List<Genre> getAll() {
        return genreDao.getAll();
    }

    public Genre getById(long id) {
        return genreDao.getById(id);
    }

    public void save(Genre genre) {
        genreDao.save(genre);
    }

    public Genre update(Genre genre) {
       return genreDao.update(genre);
    }

    public void remove(long id) {
        genreDao.remove(id);
    }

    public void detach(Genre genre) {
        genreDao.detach(genre);
    }
}
