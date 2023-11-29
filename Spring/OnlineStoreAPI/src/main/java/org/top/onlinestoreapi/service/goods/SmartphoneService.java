package org.top.onlinestoreapi.service.goods;

import org.top.onlinestoreapi.entity.goods.Smartphone;

import java.util.List;
import java.util.Optional;

public interface SmartphoneService {
    Iterable<Smartphone> getAll();
    List<Smartphone> getAllLimit();
    Optional<Smartphone> addNew(Smartphone smartphone);
    Optional<Smartphone> getById(Integer id);
    Optional<Smartphone> deleteById(Integer id);
    Optional<Smartphone> update(Smartphone smartphone);
}
