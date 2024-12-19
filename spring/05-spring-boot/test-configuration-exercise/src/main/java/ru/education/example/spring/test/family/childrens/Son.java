package ru.education.example.spring.test.family.childrens;

import org.springframework.stereotype.Component;
import ru.education.example.spring.test.family.FamilyMember;

@Component
public class Son extends FamilyMember {
    @Override
    public String getName() {
        return "Сын";
    }
}
