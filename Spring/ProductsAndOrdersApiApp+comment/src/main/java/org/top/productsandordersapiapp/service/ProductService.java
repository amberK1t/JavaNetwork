package org.top.productsandordersapiapp.service;        // пакет

import org.springframework.stereotype.Service;          // импорт аннотации сервис
import org.top.productsandordersapiapp.entity.Product;  // импорт класса

import java.util.List;                                  // импорт коллекции
import java.util.Optional;                              // импорт optional

// интерфейс (контракт) описывает операции с сущностью Product
@Service // аннотация, что класс яв-ся сервисом, используется spring в DI
public interface ProductService { // интерфейс, содержит методы необходимые к реализации
    // 1. получить все записи
    List<Product> getAll(); // возвращает коллекцию продуктов
    // 2. получить запись по id
    Optional<Product> getById(Integer id); // принимает id возвращает optional продукта
    // 3. добавить новую запись
    Product add(Product product); // Принимает Product, возвращает Product
    // 4. удалить запись по id
    Boolean deleteById(Integer id); // Принимает id, возвращает true/false
    // 5. изменить запись
    Optional<Product> update(Product product); // Принимает Product, возвращает optional продукта
}
