package my.library.datajpa.repository;

import my.library.datajpa.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepo extends CrudRepository<Genre, Long> {
    List<Genre> findAll();
}
