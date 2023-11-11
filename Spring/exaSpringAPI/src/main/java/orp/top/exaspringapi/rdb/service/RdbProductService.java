package orp.top.exaspringapi.rdb.service;

import org.springframework.stereotype.Service;
import orp.top.exaspringapi.entity.Product;
import orp.top.exaspringapi.rdb.repository.ProductRepository;
import orp.top.exaspringapi.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class RdbProductService implements ProductService {
    private final ProductRepository productRepository;

    public RdbProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteById(Integer id) {
        Optional<Product> find = productRepository.findById(id);
        if (find.isPresent()) {
            productRepository.deleteById(id);
        }
        return find.isPresent();
    }

    @Override
    public Optional<Product> update(Product product) {
        Optional<Product> find = productRepository.findById(product.getId());
        if (find.isPresent()) {
            productRepository.save(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> getByName(String productName) {
        return productRepository.getProductByTitle(productName);
    }
}
