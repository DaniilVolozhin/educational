package my.library.datajpa.controller;

import my.library.datajpa.entity.Book;
import my.library.datajpa.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book", produces = "application/json", consumes = "application/json")
public class BooksController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable("id")long id) {
        return bookRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postBook(@RequestBody Book book) {
        bookRepo.save(book);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Book putBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Book patchBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("id")long id) {
        bookRepo.deleteById(id);
    }
}
