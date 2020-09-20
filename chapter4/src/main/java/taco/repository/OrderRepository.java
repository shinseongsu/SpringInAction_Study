package taco.repository;

import org.springframework.data.repository.CrudRepository;
import taco.vo.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
