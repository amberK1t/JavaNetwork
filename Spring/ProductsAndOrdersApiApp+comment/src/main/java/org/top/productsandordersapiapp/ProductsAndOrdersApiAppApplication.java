package org.top.productsandordersapiapp; // пакет

import org.springframework.boot.SpringApplication; // импорт spring api
import org.springframework.boot.autoconfigure.SpringBootApplication; // импорт spring api config

@SpringBootApplication // аннотация spring api, autoconfig, component scan, configuration
public class ProductsAndOrdersApiAppApplication { // класс запуска spring api

	public static void main(String[] args) { // точка входа, main
		SpringApplication.run(ProductsAndOrdersApiAppApplication.class, args); // запуск приложения
	}

}
