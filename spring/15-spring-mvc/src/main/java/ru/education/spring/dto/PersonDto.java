package ru.education.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.education.spring.domain.Person;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private int id;
    private String name;

    public static Person toDomainObject(PersonDto dto) {
        return new Person(dto.getId(), dto.getName());
    }

    public static PersonDto toDto(Person account) {
        return new PersonDto(account.getId(), account.getName());
    }
}
