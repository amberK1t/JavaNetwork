package org.top.onlinestoreapi.service;

import org.top.onlinestoreapi.entity.Client;
import org.top.onlinestoreapi.entity.Order;
import org.top.onlinestoreapi.entity.Position;

import java.util.Optional;

public interface OrderService {
    Iterable<Order> getAll();
    Optional<Order> getById(Integer id);
    Optional<Order> add(Order order);
    Optional<Order> update(Order order);
    Optional<Order> deleteById(Integer id);

    boolean buyItem(Integer itemId, Integer clientId);

    Optional<Order> findNotClosedOrder(Integer clientId);

    Optional<Position> findPositionByOrderIdAndItemId(Integer orderId, Integer itemId);
}
