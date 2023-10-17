package org.top.sportapi.controller;

import org.springframework.web.bind.annotation.*;
import org.top.sportapi.rdb.ProductRepository;
import org.top.sportapi.entity.SportingGoods;

import java.util.Optional;

@RestController
@RequestMapping("sport")
public class ApplicationController {
    private final ProductRepository productRepository;

    public ApplicationController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public Iterable<SportingGoods> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<SportingGoods> getById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @PostMapping("new")
    public SportingGoods addNew(@RequestBody SportingGoods sportingGoods) {
        return productRepository.save(sportingGoods);
    }

    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        Optional<SportingGoods> deleted = productRepository.findById(id);
        if (deleted.isPresent()) {
            productRepository.deleteById(id);
        }
        return deleted.isPresent();
    }

    @PostMapping("update")
    public Optional<SportingGoods> update(@RequestBody SportingGoods sportingGoods) {
        Optional<SportingGoods> updated = productRepository.findById(sportingGoods.getId());
        if (updated.isPresent()) {
            productRepository.save(sportingGoods);
            return Optional.of(sportingGoods);
        }
        return Optional.empty();
    }
}

