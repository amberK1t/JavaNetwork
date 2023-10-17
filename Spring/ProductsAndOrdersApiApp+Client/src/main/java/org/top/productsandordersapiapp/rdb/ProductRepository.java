package org.top.productsandordersapiapp.rdb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.productsandordersapiapp.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
