package ru.education.example.conditionalandprofilesdemo.model;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import ru.education.example.conditionalandprofilesdemo.model.base.Friend;
import ru.education.example.conditionalandprofilesdemo.model.conditions.YanaConditions;


@Conditional(YanaConditions.class)
@Component
public class Yana extends Friend {
    @Override
    public String getName() {
        return "Яна";
    }
}
