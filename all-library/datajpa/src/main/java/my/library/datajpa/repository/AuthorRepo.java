package my.library.datajpa.repository;

import my.library.datajpa.entity.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {
    List<Author> findAll();
}
