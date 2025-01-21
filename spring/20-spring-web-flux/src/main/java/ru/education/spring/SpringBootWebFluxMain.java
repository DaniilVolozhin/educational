package ru.education.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.education.spring.domain.Person;
import ru.education.spring.repository.PersonRepository;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootWebFluxMain {

    public static void main( String[] args ) {
        ApplicationContext context = SpringApplication.run( SpringBootWebFluxMain.class );
        PersonRepository repository = context.getBean( PersonRepository.class );

        repository.saveAll( Arrays.asList(
                new Person( "Pushkin", 22 ),
                new Person( "Lermontov", 22 ),
                new Person( "Tolstoy", 60 )
        ) ).subscribe( p -> System.out.println( p.getLastName() ) );

    }
}


