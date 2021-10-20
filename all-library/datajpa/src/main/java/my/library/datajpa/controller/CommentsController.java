package my.library.datajpa.controller;

import my.library.datajpa.entity.Comment;
import my.library.datajpa.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {
    @Autowired
    private CommentRepo commentRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postComment(@RequestBody Comment comment) {
        commentRepo.save(comment);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Comment putComment(@RequestBody Comment comment) {
        return commentRepo.save(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") long id) {
        commentRepo.deleteById(id);
    }

}
