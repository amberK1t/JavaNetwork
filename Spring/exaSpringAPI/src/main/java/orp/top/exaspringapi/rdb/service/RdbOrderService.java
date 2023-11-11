package orp.top.exaspringapi.rdb.service;

import org.springframework.stereotype.Service;
import orp.top.exaspringapi.entity.Order;
import orp.top.exaspringapi.rdb.repository.OrderRepository;
import orp.top.exaspringapi.service.OrderService;


import java.util.List;
import java.util.Optional;

@Service
public class RdbOrderService implements OrderService {
    private final OrderRepository orderRepository;

    public RdbOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> add(Order order) {
        return Optional.of(orderRepository.save(order));
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> getByOrderId(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Boolean deleteById(Integer orderId) {
        Optional<Order> find = orderRepository.findById(orderId);
        if (find.isPresent()) {
            orderRepository.deleteById(orderId);
        }
        return find.isPresent();
    }
}
