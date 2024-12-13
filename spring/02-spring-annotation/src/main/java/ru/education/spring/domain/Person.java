package ru.education.spring.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Person {

    private final String name;
    private final int age;

}
