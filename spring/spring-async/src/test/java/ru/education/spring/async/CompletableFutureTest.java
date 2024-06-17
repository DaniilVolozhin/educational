package ru.education.spring.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.education.spring.async.service.CompletableFutureServiceTest;

@SpringBootTest
public class CompletableFutureTest {
  @Autowired
  private CompletableFutureServiceTest completableFutureServiceTest;

  @Test
  void when() {
    CompletableFuture<List<String>> list = completableFutureServiceTest.getStringListAsync();
    System.out.println("after completableFutureServiceTest");

    System.out.println("list" + list.join());
  }
}
