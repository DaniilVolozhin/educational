package ru.education.spring.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CompletableFutureServiceTest {

  @Async
  public CompletableFuture<List<String>> getStringListAsync() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
    }
    System.out.println("I Am CompletableFutureServiceTest getStringListAsync");
    return CompletableFuture.completedFuture(List.of("dlfjdkf", "kdfjdklfdflk"));

  }

}
