package org.top.onlinestoreapi.repository.goods;

import org.springframework.data.repository.CrudRepository;
import org.top.onlinestoreapi.entity.goods.Smartphone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Integer> {
}
