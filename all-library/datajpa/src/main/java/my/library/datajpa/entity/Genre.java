package my.library.datajpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", type=" + type +
                ", books=" +
                '}';
    }
}
