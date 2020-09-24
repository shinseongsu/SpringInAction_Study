package taco.vo;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;
import taco.repository.IngrendientResourceAssembler;

import java.util.Date;
import java.util.List;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoResource extends ResourceSupport {

    private static final IngrendientResourceAssembler
                ingredientAssembler = new IngrendientResourceAssembler();

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<IngredientResource> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toResources(taco.getIngredients());
    }

}
