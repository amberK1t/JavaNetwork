package org.top.onlinestoreapi.rdb;

import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.Manufacturer;
import org.top.onlinestoreapi.service.ManufacturerService;
import org.top.onlinestoreapi.repository.ManufacturerRepository;

import java.util.Optional;

@Service
public class RdbManufacturerService implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    public RdbManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }
    @Override
    public Iterable<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> getById(Integer id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> addNew(Manufacturer manufacturer) {
        return Optional.of(manufacturerRepository.save(manufacturer));
    }

    @Override
    public Optional<Manufacturer> update(Manufacturer manufacturer) {
        Optional<Manufacturer> find = manufacturerRepository.findById(manufacturer.getId());
        if (find.isPresent()) {
            find = Optional.of(manufacturerRepository.save(manufacturer));
        }
        return find;
    }

    @Override
    public Optional<Manufacturer> deleteByID(Integer id) {
        Optional<Manufacturer> find = manufacturerRepository.findById(id);
        if (find.isPresent()) {
            manufacturerRepository.deleteById(id);
        }
        return find;
    }
}
