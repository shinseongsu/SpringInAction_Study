package taco.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import taco.repository.OrderRepository;
import taco.vo.Order;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    /**
     *
     * /orders/current url 경로의 GET 요청
     *
     * @return
     */
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    /**
     *
     * /orders url 경로의 POST 요청
     *
     * @param order
     * @return
     */
    @PostMapping
    public String processOrder(@Valid Order order
                        , Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
