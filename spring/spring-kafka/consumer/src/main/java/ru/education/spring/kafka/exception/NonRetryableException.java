package ru.education.spring.kafka.exception;

public class NonRetryableException extends RuntimeException {

  public NonRetryableException(String message) {
    super(message);
  }

  public NonRetryableException(Throwable cause) {
    super(cause);
  }
}
