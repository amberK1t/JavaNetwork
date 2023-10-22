package org.top.productsandordersapiapp.controller;

import org.springframework.web.bind.annotation.*;
import org.top.productsandordersapiapp.entity.Order;
import org.top.productsandordersapiapp.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public List<Order> findAll() {
        return orderService.getAll();
    }

    @PostMapping("new")
    public Optional<Order> addNew(@RequestBody Order order) {
        return orderService.add(order);
    }

    @GetMapping("{id}")
    public Optional<Order> getByOrderId(@PathVariable Integer id) {
        return orderService.getByOrderId(id);
    }

    @GetMapping("/client/{id}")
    public List<Order> getByClientId(@PathVariable Integer id) {
        return orderService.getAllByClientId(id);
    }

    @PostMapping("update/{id}")
    public Optional<Order> update(@PathVariable Integer id, @RequestParam String description) {
        return orderService.updateDescription(id, description);
    }


}
