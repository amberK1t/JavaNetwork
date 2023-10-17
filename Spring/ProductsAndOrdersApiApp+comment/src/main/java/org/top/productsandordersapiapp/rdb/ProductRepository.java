package org.top.productsandordersapiapp.rdb;                // пакет

import org.springframework.data.repository.CrudRepository;  // импорт crud репозитория
import org.springframework.stereotype.Repository;           // импорт аннотации
import org.top.productsandordersapiapp.entity.Product;      // импорт класса

@Repository // аннотация репозитория
public interface ProductRepository extends CrudRepository<Product, Integer> { // интерфейс, наследуется от интерфейса CrudRepository
                                                                            // в generic передается тип сущности, и тип первичного ключа
                                                                            // интерфейс дает возможность использовать базовые crud операции
                                                                            // также есть возможность расширить своими методами
}
