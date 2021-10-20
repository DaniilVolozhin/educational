package my.library.datajpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Book {
    public Book(String name, List<Author> authors, Genre genre) {
        this.name = name;
        this.authors = authors;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1, message = "Enter the name of the book")
    private String name;

    @Size(min = 1, message = "The book must have at least 1 author.")
    @ManyToMany(targetEntity = Author.class)
    private List<Author> authors;

    @NotNull(message = "Genre должен быть задан")
    @ManyToOne
    private Genre genre;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name +
                ", comments='" + '}';
    }
}
