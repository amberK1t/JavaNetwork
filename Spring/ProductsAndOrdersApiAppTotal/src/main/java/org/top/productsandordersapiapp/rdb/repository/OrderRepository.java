package org.top.productsandordersapiapp.rdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.productsandordersapiapp.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    Iterable<Order> findAllByClientId(Integer clientId);
}
