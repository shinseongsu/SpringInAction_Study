package taco.repository;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import taco.controller.DesignRestController;
import taco.vo.Ingredient;
import taco.vo.IngredientResource;

public class IngrendientResourceAssembler extends
        ResourceAssemblerSupport<Ingredient, IngredientResource> {


    public IngrendientResourceAssembler() {
        super(DesignRestController.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return createResourceWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientResource instantiateResource( Ingredient ingredient ) {
        return new IngredientResource(ingredient);
    }

}
