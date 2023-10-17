package org.top.productsandordersapiapp.controller;     // пакет

import org.springframework.web.bind.annotation.GetMapping;      // импорт get запросов
import org.springframework.web.bind.annotation.RestController; // импорт rest контроллера

@RestController                     // аннотация rest контроллера, помечает класс как обработчик запросов
public class MainController {       // класс базового контроллера для теста, пинга

    @GetMapping("")               //аннотация get запроса по адресу http://localhost:8080/
    public String index() {         // метод проверки,
        return "Server is running"; // возвращает строку
    }

    @GetMapping("ping")           // аннотация get запроса по адресу http://localhost:8080/ping
    public String ping() {          // метод пинга
        return "pong";              // возвращает строку
    }
}
