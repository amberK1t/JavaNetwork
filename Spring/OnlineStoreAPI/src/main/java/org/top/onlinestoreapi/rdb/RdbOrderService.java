package org.top.onlinestoreapi.rdb;

import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.Order;
import org.top.onlinestoreapi.rdb.repository.OrderRepository;
import org.top.onlinestoreapi.service.OrderService;

import java.util.Optional;

@Service
public class RdbOrderService implements OrderService {

    private final OrderRepository orderRepository;
    public RdbOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<Order> add(Order order) {
        return Optional.of(orderRepository.save(order));
    }

    @Override
    public Optional<Order> update(Order order) {
        Optional<Order> find = orderRepository.findById(order.getId());
        if (find.isPresent()) {
            orderRepository.save(order);
        }
        return find;
    }

    @Override
    public Optional<Order> deleteById(Integer id) {
        Optional<Order> find = orderRepository.findById(id);
        if (find.isPresent()) {
            orderRepository.deleteById(id);
        }
        return find;
    }
}
