package orp.top.exaspringapi.rdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import orp.top.exaspringapi.entity.ProductOrder;

@Repository
public interface ProductOrderRepository extends CrudRepository<ProductOrder, Integer> {
}
