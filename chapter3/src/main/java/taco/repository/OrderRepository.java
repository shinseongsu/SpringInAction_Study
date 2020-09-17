package taco.repository;

import taco.vo.Order;

public interface OrderRepository {
    Order save(Order order);
}
