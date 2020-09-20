package taco.repository;

import org.springframework.data.repository.CrudRepository;
import taco.vo.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
