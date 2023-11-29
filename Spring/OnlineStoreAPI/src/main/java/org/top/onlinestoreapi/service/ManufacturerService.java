package org.top.onlinestoreapi.service;

import org.top.onlinestoreapi.entity.Manufacturer;

import java.util.Optional;

public interface ManufacturerService {
    Iterable<Manufacturer> getAll();
    Optional<Manufacturer> getById(Integer id);
    Optional<Manufacturer> addNew(Manufacturer manufacturer);
    Optional<Manufacturer> update(Manufacturer manufacturer);
    Optional<Manufacturer> deleteByID(Integer id);

}
