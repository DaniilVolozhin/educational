package ru.education.spring.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* ru.education.spring.aop.dao.PersonDaoSimple.findByName(String))")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Прокси : " + joinPoint.getThis().getClass().getName());
        System.out.println("Класс : " + joinPoint.getTarget().getClass().getName());

        System.out.println("Вызов метода : " + joinPoint.getSignature().getName());
        System.out.println("Аргументы метода : " + Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed(joinPoint.getArgs());

        System.out.println("Результат : " + result);

        return result;
    }

    @Before("execution(* ru.education.spring.aop.dao.PersonDaoSimple.findByName(String))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Прокси : " + joinPoint.getThis().getClass().getName());
        System.out.println("Класс : " + joinPoint.getTarget().getClass().getName());

        System.out.println("Вызов метода : " + joinPoint.getSignature().getName());
    }
}
