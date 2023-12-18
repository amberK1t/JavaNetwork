package org.top.onlinestoreapi.rdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.onlinestoreapi.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
    Iterable<Item> findAllByType(String type);
}
