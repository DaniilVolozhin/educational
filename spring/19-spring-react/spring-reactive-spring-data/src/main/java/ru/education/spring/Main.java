package ru.education.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.education.spring.domain.Account;
import ru.education.spring.domain.Person;
import ru.education.spring.repostory.AccountRepository;
import ru.education.spring.repostory.PersonRepository;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(Main.class);

        PersonRepository repository = context.getBean(PersonRepository.class);
        AccountRepository accountRepository = context.getBean(AccountRepository.class);

        repository.findById("1")
//                позволяет синхронно выполнить 2 запроса
                .zipWith(accountRepository.findById("1"))
                .flatMap(a -> {
                    Person t1 = a.getT1();
                    Account t2 = a.getT2();
                    t1.setName(t2.getAmount().toString());
                    return repository.save(t1);
                }).subscribe();

        Thread.sleep(20000);
    }
}
