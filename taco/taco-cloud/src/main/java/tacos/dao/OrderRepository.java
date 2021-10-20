package tacos.dao;

import tacos.entity.Order;

public interface OrderRepository {
    Order save(Order ingredient);
}
