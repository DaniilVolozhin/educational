package my.lilbraryorm.domain;

import my.lilbraryorm.entity.Author;
import my.lilbraryorm.entity.Book;
import my.lilbraryorm.entity.Genre;
import my.lilbraryorm.entity.Test;
import my.lilbraryorm.service.AuthorService;
import my.lilbraryorm.service.BookService;
import my.lilbraryorm.service.GenreService;
import my.lilbraryorm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Arrays;

import static java.util.Arrays.asList;

@ShellComponent
public class ShellMain {
    @Autowired
    private GenreService genreService;
    @Autowired
    private TestService testService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    private Genre g;
    private Author a;

    @ShellMethod(key = "main", value = "main")
    public void main() {
        genre();
        author();
        Book book = new Book("TestBookCascade", asList(a), g);
        a.setBooks(asList(book));
        g.setBooks(asList(book));
        bookService.save(book);
        log(bookService.getAll());

        authorService.remove(a.getId());
        log(bookService.getAll());
    }

    @ShellMethod(key = "genre", value = "all")
    public void genre() {
        Arrays.stream(Type.values()).forEach(t -> genreService.save(new Genre(t.toString())));
        log(genreService.getAll());
        g = genreService.getById(1);
        g.setType("TEST");
        genreService.remove(2);
        log(genreService.getAll());
        g = genreService.update(g);
    }

    @ShellMethod(key = "book", value = "all")
    public void book() {
    }

    @ShellMethod(key = "author", value = "all")
    public void author() {
        authorService.save(new Author("Test", "Test", "Test"));
        a = new Author("Test1", "Test1", "Test1");
        authorService.save(a);
        authorService.save(new Author("Test2", "Test2", "Test2"));
        authorService.save(new Author("Test3", "Test3", "Test3"));
        authorService.save(new Author("Test4", "Test4", "Test4"));
        log(authorService.getAll());
        authorService.remove(1);
        log(authorService.getAll());
        a.setLastName("test");
        a = authorService.update(a);

    }

    @ShellMethod(key = "test", value = "test")
    public void test() {
        testService.save(new Test("test1"));
        testService.save(new Test("test2"));
        testService.save(new Test("test3"));
        testService.save(new Test("test3"));
        testService.save(new Test("test4"));
        log(testService.get());
    }

    private void log(Object o) {
        System.out.println(o);
    }

    public static enum Type {
        BUSINESS_BOOKS, CLASSIC_LITERATURE, FOREIGN_LITERATURE, RUSSIAN, FICTION, MODERN_PROSE, ADVENTURE, HORROR, MYSTERY
    }

}
