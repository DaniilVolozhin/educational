package ru.education.example.beansscopesdemo.services;

import org.springframework.stereotype.Service;

@Service("SingletonGreetingService")
public class SingletonGreetingServiceImpl extends AbstractGreetingServiceImpl {
}
