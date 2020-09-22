package taco.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import taco.vo.Order;
import taco.vo.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
