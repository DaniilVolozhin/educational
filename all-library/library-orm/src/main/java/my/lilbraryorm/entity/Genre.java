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
public class Genre {
    public Genre(String type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 1, message = "Enter a genre name")
    @NotNull
    private String type;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Book> books;

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", type=" + type +
                ", books=" + books +
                '}';
    }
}
