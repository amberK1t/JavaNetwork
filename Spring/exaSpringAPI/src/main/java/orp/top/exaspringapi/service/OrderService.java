package orp.top.exaspringapi.service;

import org.springframework.stereotype.Service;
import orp.top.exaspringapi.entity.Order;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Optional<Order> add(Order order);
    List<Order> getAll();
    Optional<Order> getByOrderId(Integer id);
    Boolean deleteById(Integer orderId);
}
