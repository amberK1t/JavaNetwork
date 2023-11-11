package orp.top.exaspringapi.controller;

import org.springframework.web.bind.annotation.*;
import orp.top.exaspringapi.entity.Product;
import orp.top.exaspringapi.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("new")
    public Product addNew(@RequestBody Product product) {
        return productService.add(product);
    }

    @DeleteMapping("{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        return productService.deleteById(id);
    }

    @PostMapping("update")
    public Optional<Product> update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("")
    public List<Product> findAll() {
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Product> findById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Product> findByName(@PathVariable String name) {
        return productService.getByName(name);
    }
}
