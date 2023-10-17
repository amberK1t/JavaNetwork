package org.top.productsandordersapiapp.config;                 //пакет

import org.springframework.context.annotation.Bean;             // импорт библиотеки зависимости
import org.springframework.context.annotation.Configuration;    // импорт библиотеки конфига
import org.top.productsandordersapiapp.rdb.ProductRepository;   //импорт необходимого интерфейса
import org.top.productsandordersapiapp.rdb.RdbProductService;   //импорт необходимого класса
import org.top.productsandordersapiapp.service.ProductService;  //импорт необходимого интерфейса

// Конфигурация зависимостей приложения
@Configuration // аннотация конфига, помечает класс-конфигурацию
public class AppConfig { //класс конфига

    @Bean // аннотация бина(зависимости)
    public ProductService productService(ProductRepository productRepository) { //метод, который возвращает реализацию интерфейса ProductService
        return new RdbProductService(productRepository);                        // в виде нового экземпляра RdbProductService
    }
}
