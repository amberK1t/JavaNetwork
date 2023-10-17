package org.top.productsandordersapiapp.controller;             // пакет

import org.springframework.web.bind.annotation.*;               // импорт аннотаций
import org.top.productsandordersapiapp.entity.Product;          // импорт класса
import org.top.productsandordersapiapp.service.ProductService; // импорт интерфейса

import java.util.List; // импорт коллекции лист
import java.util.Optional; // импорт optional

@RestController     // аннотация rest контроллера, помечает класс как обработчик запросов
public class ProductController { //класс обработчик запросов

    private final ProductService productService; //поле интерфейса, для дальнейшего вызова в обработке запроса,
                                                // RdbProductService реализует этот интерфейс с использованием
                                                // интерфейса ProductRepository унаследованного от CrudRepository
    public ProductController(ProductService productService) { // инъекция зависимости через конструктор
        this.productService = productService;                   // присвоение зависимости
    }

    // ОБРАБОТЧИКИ, ВЫЗЫВАЮЩИЕ ОПЕРАЦИИ ПО ВЗАИМОДЕЙСТВИЮ С БД
    // 1. получить все записи
    @GetMapping("product")              //аннотация get запроса по адресу http://localhost:8080/product
    public List<Product> findAll() {        // метод возвращает список продуктов
        return productService.getAll();     //возвращается лист, вызывается метод интерфейса, интерфейс реализуется в RdbProductService с использованием
                                            // ProductRepository расширяемый CrudRepository
    }

    // 2. получить запись по id
    @GetMapping("product/{id}")         //аннотация get запроса по адресу http://localhost:8080/product/1 http://localhost:8080/product/2 и т.д исп. маска
    public Optional<Product> findById(@PathVariable Integer id) { //метод, возвращает optional продукта, принимает переменную из пути адреса
        return productService.getById(id);                      //возвращает реализацию метода интерфейса
    }

    // 3. добавить новую запись
    @PostMapping("product/new")                           //аннотация post запроса по адресу http://localhost:8080/new
    public Product addNew(@RequestBody Product product) {   //метод, возвращает Product, принимает json из тела запроса в виде объекта
        return productService.add(product);                 //возвращает реализацию метода интерфейса
    }

    // 4. удалить запись по id
    @DeleteMapping("product/{id}")      //аннотация delete запроса по адресу http://localhost:8080/product/1 http://localhost:8080/product/2 и т.д исп. маска
    public Boolean deleteById(@PathVariable Integer id) {   //метод, возвращает true/false, принимает переменную из пути адреса
        return productService.deleteById(id);               //возвращает реализацию метода интерфейса
    }

    // 5. изменить запись
    @PostMapping("product/update")                      //аннотация post запроса по адресу http://localhost:8080/update
    public Optional<Product> updateExisting(@RequestBody Product product) { //метод, возвращает optional продукта, принимает json из тела запроса в виде объекта
        return productService.update(product);              //возвращает реализацию метода интерфейса
                                                            //уффф
    }
}
