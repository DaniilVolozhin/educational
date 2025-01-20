package ru.education.spring.repostory;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.education.spring.domain.Account;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
}
