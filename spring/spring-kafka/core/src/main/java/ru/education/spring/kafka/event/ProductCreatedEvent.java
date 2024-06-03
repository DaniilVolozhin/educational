package ru.education.spring.kafka.event;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {

  private String productId;
  private String title;
  private BigDecimal price;
  private Integer quantity;
}
