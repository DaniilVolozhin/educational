package ru.education.spring.kafka.dto;

import java.math.BigDecimal;

public class CreateProductDTO {

  private String title;
  private BigDecimal price;
  private Integer quantity;

  public CreateProductDTO() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

}
