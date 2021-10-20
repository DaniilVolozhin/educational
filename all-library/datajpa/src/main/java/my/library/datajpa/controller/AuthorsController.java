package my.library.datajpa.controller;

import my.library.datajpa.entity.Author;
import my.library.datajpa.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/author", produces = "application/json", consumes = "application/json")
public class AuthorsController {
    @Autowired
    private AuthorRepo authorRepo;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthor() {
        return authorRepo.findAll();
    }

//    @GetMapping("/book/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Author> getAuthorsByBookId(@PathVariable("id") long bookId) {
//        return authorRepo.getAuthorsByBookId(bookId);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable("id") long id) {
        return authorRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postAuthor(@RequestBody Author author) {
        authorRepo.save(author);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Author putAuthor(@RequestBody Author author) {
        return authorRepo.save(author);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Author patchAuthor(@RequestBody Author author) {
        return authorRepo.save(author);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable long id) {
        authorRepo.deleteById(id);
    }
}
