package org.top.productsandordersapiapp.mock;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Product;
import org.top.productsandordersapiapp.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockProductService implements ProductService {

    private static final List<Product> products = new ArrayList<>();
    private static Integer nextId = 1;

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    @Override
    public Optional<Product> getById(Integer id) {
        // return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public Product add(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    @Override
    public Boolean deleteById(Integer id) {
        Optional<Product> deleted = getById(id);
        deleted.ifPresent(products::remove);
        return deleted.isPresent();
    }

    @Override
    public Optional<Product> update(Product product) {
        Optional<Product> updated = getById(product.getId());
        if (updated.isEmpty()) {
            return Optional.empty();
        }
        //
        updated.get().setTitle(product.getTitle());
        updated.get().setPrice(product.getPrice());
        updated.get().setQuantity(product.getQuantity());
        updated.get().setDescription(product.getDescription());
        //
        return updated;
    }
}
