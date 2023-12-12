package org.top.onlinestoreapi.service;

import org.top.onlinestoreapi.entity.Order;

import java.util.Optional;

public interface OrderService {
    Iterable<Order> getAll();
    Optional<Order> getById(Integer id);
    Optional<Order> add(Order order);
    Optional<Order> update(Order order);
    Optional<Order> deleteById(Integer id);
}
