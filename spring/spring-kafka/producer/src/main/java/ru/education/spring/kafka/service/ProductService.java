package ru.education.spring.kafka.service;

import java.util.concurrent.ExecutionException;
import ru.education.spring.kafka.dto.CreateProductDTO;

public interface ProductService {

  String createProduct(CreateProductDTO createProductDTO)
      throws ExecutionException, InterruptedException;

}
