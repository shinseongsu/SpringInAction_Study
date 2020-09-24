package taco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.repository.OrderRepository;
import taco.repository.TacoRepository;
import taco.repository.TacoResourceAssembler;
import taco.vo.Order;
import taco.vo.Taco;
import taco.vo.TacoResource;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(path="/restDesign",
                produces = "application/json")
//@RequestMapping(path="/restDesign", produces = {"application/json", "text/xml"})
@CrossOrigin(origins = "*")
public class DesignRestController {

    private TacoRepository tacoRepo;
    private OrderRepository repo;

    @Autowired
    EntityLinks entityLinks;

    public DesignRestController(TacoRepository tacoRepo, OrderRepository repo) {
        this.tacoRepo = tacoRepo;
        this.repo = repo;
    }

    @GetMapping("/recent")
    public Resources<TacoResource> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12 , Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();

        List<TacoResource> tacoResources =
                new TacoResourceAssembler().toResources(tacos);
        Resources<TacoResource> recentResources =
                new Resources<TacoResource>(tacoResources);

//        recentResources.add(
//                new Link("http://localhost:9090/design/recent", "recents"));

        /*
        *   호스트 이름을 하드 코딩할 필요가 없으며, /design 경로 역시 지정하지 않아도 된다.
        *   slash() 메소드를 호출하여, 인자로 전달된 값을 URL에 추가한다.
         */

       // recentResources.add(
       //         ControllerLinkBuilder.linkTo(DesignRestController.class)
       //                              .slash("recent")
       //                              .withRel("recents"));

        recentResources.add(
                linkTo( methodOn(DesignRestController.class).recentTacos())
                    .withRel("recents"));

        return recentResources;
    }

/*
    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if(optTaco.isPresent()) {
            return optTaco.get();
        }
        return null;
    }
*/
    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if(optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }

    @PutMapping("/{orderId}")
    public Order putOrder(@RequestBody Order order) {
        return repo.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable("orderId") Long orderId,
                            @RequestBody Order patch) {

        Order order = repo.findById(orderId).get();
        if(patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if(patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if(patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if(patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryStreet());
        }
        if(patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if(patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if(patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        if(patch.getCcCVV() != null) {
            order.setCcCVV(patch.getCcCVV());
        }

        return repo.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            repo.deleteById(orderId);
        } catch(EmptyResultDataAccessException e) { }
    }


}
