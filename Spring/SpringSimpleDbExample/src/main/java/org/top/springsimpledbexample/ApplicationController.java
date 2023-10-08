package org.top.springsimpledbexample;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// Контроллер - веб-интерфейс приложения
@RestController
public class ApplicationController {

    // репозиторий для работы с объектами (использование DI)
    private final ProductRepository productRepository;

    public ApplicationController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // дефолтные обработчики
    @GetMapping("")
    public String index() {
        return "Server is running";
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    // ОБРАБОТЧИКИ, ВЫЗЫВАЮЩИЕ ОПЕРАЦИИ ПО ВЗАИМОДЕЙСТВИЮ С БД
    // 1. получить все записи
    @GetMapping("product")
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    // 2. получить запись по id
    @GetMapping("product/{id}")
    public Optional<Product> findById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    // 3. добавить новую запись
    @PostMapping("product/new")
    public Product addNew(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // 4. удалить запись по id
    @DeleteMapping("product/{id}")
    public Optional<Product> deleteById(@PathVariable Integer id) {
        Optional<Product> deleted = productRepository.findById(id); // пробуем найти удаляемый объект
        if (deleted.isPresent()) {
            // если он присутствует, то удалить его
            productRepository.deleteById(id);
        }
        return deleted; // вернуть удаляемый (вернется удаленный объект, либо null если объекта с таким id не было)
    }
    // 5. изменить запись
    @PostMapping("product/update")
    public Optional<Product> updateExisting(@RequestBody Product product) {
        // 1. Проверяем есть ли такая запись
        Optional<Product> updated = productRepository.findById(product.getId());
        // 2. если он есть, то обновить ее данные
        if (updated.isPresent()) {
            productRepository.save(product);
            return Optional.of(product);
        }
        // 3. вернуть пустое значение
        return Optional.empty();
    }
}

