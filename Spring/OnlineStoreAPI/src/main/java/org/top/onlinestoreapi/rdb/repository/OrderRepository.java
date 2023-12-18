package org.top.onlinestoreapi.rdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.onlinestoreapi.entity.Order;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
