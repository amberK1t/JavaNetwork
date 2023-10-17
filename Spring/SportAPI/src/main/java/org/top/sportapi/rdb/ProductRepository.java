package org.top.sportapi.rdb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.sportapi.entity.SportingGoods;

@Repository
public interface ProductRepository extends CrudRepository<SportingGoods, Integer> {
}
