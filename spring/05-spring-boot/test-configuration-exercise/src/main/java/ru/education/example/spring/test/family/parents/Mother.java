package ru.education.example.spring.test.family.parents;

import org.springframework.stereotype.Component;
import ru.education.example.spring.test.family.FamilyMember;

@Component
public class Mother extends FamilyMember {
    @Override
    public String getName() {
        return "Мама";
    }
}
