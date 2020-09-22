package taco.repository;

import org.springframework.data.repository.CrudRepository;
import taco.vo.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}