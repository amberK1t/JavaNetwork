package orp.top.exaspringapi.service;

import org.springframework.stereotype.Service;
import orp.top.exaspringapi.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product add(Product product);
    Boolean deleteById(Integer id);
    Optional<Product> update(Product product);
    List<Product> getAll();
    Optional<Product> getById(Integer id);
    Optional<Product> getByName(String productName);
}
