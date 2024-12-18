package ru.education.example.conditionalandprofilesdemo.model.conditions;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

public class YanaConditions extends /*AllNestedConditions*/AnyNestedCondition {

    public YanaConditions() {
        super(ConfigurationPhase.PARSE_CONFIGURATION);
    }


    @ConditionalOnProperty(name = "condition.alexey-exists", havingValue = "false")
    static class AlexeyDoesNotExistsCondition {
    }

    @ConditionalOnProperty(name = "condition.yanis-exists", havingValue = "true")
    static class YanisExistsCondition {
    }
}
