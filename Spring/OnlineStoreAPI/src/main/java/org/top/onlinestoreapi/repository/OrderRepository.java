package org.top.onlinestoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.onlinestoreapi.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
