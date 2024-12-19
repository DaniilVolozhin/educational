package ru.education.example.spring.test.family.pets;

import org.springframework.stereotype.Component;
import ru.education.example.spring.test.family.FamilyMember;

@Component
//@Component("dog")
public class Dog extends FamilyMember {

    @Override
    public String getName() {
        return "Собака";
    }
}
