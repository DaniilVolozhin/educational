package ru.education.spring.boot.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@Setter
@Getter
@ConfigurationProperties(prefix = "application")
public class AppProps {

    private String message;
    private Locale locale;
}
