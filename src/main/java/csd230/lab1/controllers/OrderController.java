package csd230.lab1.controllers;

import csd230.lab1.entities.OrderEntity;
import csd230.lab1.repositories.OrderEntityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderEntityRepository orderRepository;

    public OrderController(OrderEntityRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public String orderDetails(@PathVariable Long id, Model model) {

        OrderEntity order = orderRepository.findById(id).orElse(null);

        if (order == null) {
            return "redirect:/cart";
        }

        model.addAttribute("order", order);
        return "orderDetails";
    }
}
