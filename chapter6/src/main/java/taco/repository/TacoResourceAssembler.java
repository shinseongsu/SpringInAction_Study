package taco.repository;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import taco.controller.DesignRestController;
import taco.vo.Taco;
import taco.vo.TacoResource;

public class TacoResourceAssembler extends
        ResourceAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignRestController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateResource(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toResource(Taco taco) {
        return createResourceWithId(taco.getId(), taco);
    }
}
