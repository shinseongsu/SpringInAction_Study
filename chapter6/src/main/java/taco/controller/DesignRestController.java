package taco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.repository.OrderRepository;
import taco.repository.TacoRepository;
import taco.vo.Order;
import taco.vo.Taco;

import java.util.Optional;

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
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(0, 12 , Sort.by("createdAt").descending());

        return tacoRepo.findAll(page).getContent();
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


}
