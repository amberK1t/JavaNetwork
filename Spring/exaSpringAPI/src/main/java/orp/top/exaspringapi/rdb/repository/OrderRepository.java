package orp.top.exaspringapi.rdb.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import orp.top.exaspringapi.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
