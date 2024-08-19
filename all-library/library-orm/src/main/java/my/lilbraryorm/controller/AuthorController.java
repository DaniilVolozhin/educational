package my.lilbraryorm.controller;

import my.lilbraryorm.entity.Author;
import my.lilbraryorm.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable long id) {
        return authorService.getById(id);
    }

    @GetMapping("/list")
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Author author) {
        authorService.save(author);
    }

    @PutMapping
    public Author update(@RequestBody Author author) {
        return authorService.update(author);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        authorService.remove(id);
    }
}
