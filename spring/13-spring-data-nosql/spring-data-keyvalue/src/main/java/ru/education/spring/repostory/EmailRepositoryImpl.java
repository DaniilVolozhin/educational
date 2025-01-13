package ru.education.spring.repostory;

import lombok.RequiredArgsConstructor;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.stereotype.Repository;
import ru.education.spring.domain.Email;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmailRepositoryImpl implements EmailRepository {

    private final KeyValueOperations keyValueOperations;

    @Override
    public List<Email> findAll() {
        return (List<Email>) keyValueOperations.findAll(Email.class);
    }

    @Override
    public Email save(Email email) {
        return keyValueOperations.insert(email);
    }
}
