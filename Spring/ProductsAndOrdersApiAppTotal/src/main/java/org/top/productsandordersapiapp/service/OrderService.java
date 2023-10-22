package org.top.productsandordersapiapp.service;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Order;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    // 1. Добавить новую запись
    Optional<Order> add(Order order);
    // 2. Получить все заказы
    List<Order> getAll();
    // 3. Получить заказ по id заказа
    Optional<Order> getByOrderId(Integer id);
    // 4. Получить заказы по id клиента
    List<Order> getAllByClientId(Integer clientId);
    // 5. Редактирование описания заказа
    Optional<Order> updateDescription(Integer id, String newDescription);
}
