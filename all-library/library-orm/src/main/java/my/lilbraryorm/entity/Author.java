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
public class Author {

    public Author(String surName, String lastName, String middleName) {
        this.surName = surName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;;

    @NotNull
    @Size(min = 1, message = "Enter the author's surName")
    private String surName;

    @NotNull
    @Size(min = 1, message = "Enter the author's lastName")
    private String lastName;

    @NotNull
    @Size(min = 1, message = "Enter the author's middleName")
    private String middleName;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Book> books;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", books=" + books +
                '}';
    }
}
