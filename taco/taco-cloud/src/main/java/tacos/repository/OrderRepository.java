package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.entity.Order;
import tacos.entity.User;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByZip(String zip); // название метода дает понять что нужно найти Order,
    // List указывает что нужны все ордер
    // DeliveryZip в запросе это переданный параметр deliveryZip по которому необходимо искать Order

    List<Order> readOrdersByZipAndPlacedAtBetween(String zip, Date startDate, Date endDate);

    List<Order> findByCityOrderByZip(String city);

    List<Order> findByUserOrderByPlacedAtDesc(User user);
}
