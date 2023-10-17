package org.top.productsandordersapiapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.top.productsandordersapiapp.rdb.ProductRepository;
import org.top.productsandordersapiapp.rdb.RdbProductService;
import org.top.productsandordersapiapp.service.ProductService;

// Конфигурация зависимостей приложения
@Configuration
public class AppConfig {

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new RdbProductService(productRepository);
    }
}
