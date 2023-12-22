package org.top.onlinestoreapi.rdb;

import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.Item;
import org.top.onlinestoreapi.rdb.repository.ItemRepository;
import org.top.onlinestoreapi.service.ItemService;

import java.util.*;

@Service
public class RdbItemService implements ItemService {

    private final ItemRepository itemRepository;
    public RdbItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Iterable<Item> getAll(String type) {
        return itemRepository.findAllByType(type);
    }

    @Override
    public List<Item> getAllLimit(String type) {
        try {
            List<Item> allSmart = new ArrayList<>();
            for (Item item: itemRepository.findAllByType(type)) {
                allSmart.add(item);
            }
            Collections.shuffle(allSmart);
            return allSmart.subList(0, 4);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public Optional<Item> addNew(Item smartphone) {
        return Optional.of(itemRepository.save(smartphone));
    }

    @Override
    public Optional<Item> getById(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public Optional<Item> deleteById(Integer id) {
        Optional<Item> find = itemRepository.findById(id);
        if (find.isPresent()) {
            itemRepository.deleteById(id);
        }
        return find;
    }

    @Override
    public Optional<Item> update(Item smartphone) {
        Optional<Item> find = itemRepository.findById(smartphone.getId());
        if (find.isPresent()) {
            find = Optional.of(itemRepository.save(smartphone));
        }
        return find;
    }
}
