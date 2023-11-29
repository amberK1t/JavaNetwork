package org.top.onlinestoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.onlinestoreapi.entity.Manufacturer;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
}
