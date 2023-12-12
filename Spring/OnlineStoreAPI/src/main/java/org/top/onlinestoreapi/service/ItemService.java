package org.top.onlinestoreapi.service;

import org.top.onlinestoreapi.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Iterable<Item> getAll();
    Iterable<Item> getAll(String type);
    List<Item> getAllLimit(String type);
    Optional<Item> addNew(Item smartphone);
    Optional<Item> getById(Integer id);
    Optional<Item> deleteById(Integer id);
    Optional<Item> update(Item smartphone);
}
