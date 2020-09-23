package taco.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import taco.vo.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

}
