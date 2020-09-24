package taco.vo;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import taco.vo.Ingredient.Type;

public class IngredientResource extends ResourceSupport {

    @Getter
    private String name;

    @Getter
    private Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

}
