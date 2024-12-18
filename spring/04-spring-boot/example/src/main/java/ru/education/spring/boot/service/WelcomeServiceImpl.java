package ru.education.spring.boot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.education.spring.boot.configs.AppProps;

@Slf4j
@Service
@RequiredArgsConstructor
public class WelcomeServiceImpl implements WelcomeService {

    private final MessageSource messageSource;
    private final AppProps props;

    @Override
    public void sayHello() {
        String message = messageSource.getMessage("hello.user", new String[]{"Ivan"}, props.getLocale());
        log.info("Localization:{}", message);
    }
}
