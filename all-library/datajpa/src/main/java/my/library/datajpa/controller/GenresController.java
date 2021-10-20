package my.library.datajpa.controller;

import my.library.datajpa.entity.Genre;
import my.library.datajpa.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenresController {
    @Autowired
    private GenreRepo genreRepo;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Genre> getAllGenre() {
        return genreRepo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Genre getGenreById(@PathVariable("id") long id) {
        return genreRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postGenre(@RequestBody Genre genre) {
        genreRepo.save(genre);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Genre putGenre(@RequestBody Genre genre) {
        return genreRepo.save(genre);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Genre patchGenre(@RequestBody Genre genre) {
        return genreRepo.save(genre);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGenre(@PathVariable("id") long id) {
        genreRepo.deleteById(id);
    }

}
