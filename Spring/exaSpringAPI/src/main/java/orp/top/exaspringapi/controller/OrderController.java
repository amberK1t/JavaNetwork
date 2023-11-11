package orp.top.exaspringapi.controller;

import org.springframework.web.bind.annotation.*;
import orp.top.exaspringapi.entity.Order;
import orp.top.exaspringapi.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("new")
    public Optional<Order> addNew(@RequestBody Order order) {
        return orderService.add(order);
    }

    @GetMapping("")
    public List<Order> findAll() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Order> findById(@PathVariable Integer id) {
        return orderService.getByOrderId(id);
    }

    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        return orderService.deleteById(id);
    }


}
