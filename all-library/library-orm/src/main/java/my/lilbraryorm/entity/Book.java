package my.lilbraryorm.entity;

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
    @JoinTable(joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Author> authors;

    @NotNull(message = "Genre должен быть задан")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name +
                ", comments='" + comments+ '}';
    }
}
