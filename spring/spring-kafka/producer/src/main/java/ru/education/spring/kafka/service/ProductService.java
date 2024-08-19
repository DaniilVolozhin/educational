package ru.education.spring.kafka.service;

import ru.education.spring.kafka.dto.CreateProductDTO;

import java.util.concurrent.ExecutionException;

public interface ProductService {

  String createProduct(CreateProductDTO createProductDTO)
      throws ExecutionException, InterruptedException;

}
