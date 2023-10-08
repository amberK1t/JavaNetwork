package org.top.sportapi;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ApplicationController {
    private final ProductRepository productRepository;

    public ApplicationController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public String index() {
        return "Server is running";
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("sport")
    public Iterable<SportingGoods> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("sport/{id}")
    public Optional<SportingGoods> getById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @PostMapping("sport/new")
    public SportingGoods addNew(@RequestBody SportingGoods sportingGoods) {
        return productRepository.save(sportingGoods);
    }

    @DeleteMapping("sport/{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        Optional<SportingGoods> deleted = productRepository.findById(id);
        if (deleted.isPresent()) {
            productRepository.deleteById(id);
        }
        return deleted.isPresent();
    }

    @PostMapping("sport/update")
    public Optional<SportingGoods> update(@RequestBody SportingGoods sportingGoods) {
        Optional<SportingGoods> updated = productRepository.findById(sportingGoods.getId());
        if (updated.isPresent()) {
            productRepository.save(sportingGoods);
            return Optional.of(sportingGoods);
        }
        return Optional.empty();
    }
}

