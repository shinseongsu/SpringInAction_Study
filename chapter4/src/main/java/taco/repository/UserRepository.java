package taco.repository;

import org.springframework.data.repository.CrudRepository;
import taco.vo.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
