package ru.education.spring.boot.starter;

public class MessagerConfig {
    private final String message;

    public MessagerConfig(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
