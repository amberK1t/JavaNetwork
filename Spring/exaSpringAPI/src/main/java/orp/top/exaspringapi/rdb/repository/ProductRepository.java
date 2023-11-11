package orp.top.exaspringapi.rdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import orp.top.exaspringapi.entity.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Optional<Product> getProductByTitle(String productName);
}
