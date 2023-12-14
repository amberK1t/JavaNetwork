package org.top.onlinestoreapi.rdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.onlinestoreapi.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    Iterable<Item> findAllByType(String type);
}
