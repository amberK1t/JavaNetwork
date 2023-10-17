package org.top.productsandordersapiapp.service;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Client;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    // 1. Добавить клиента
    Optional<Client> add(Client client);
    // 2. Получить всех клиентов
    List<Client> getAll();
    // 3. Получить клиента по id
    Optional<Client> getById(Integer id);
    // 4. Удалить клиента по id
    Boolean deleteById(Integer id);
    // 5. Изменить клиента
    Optional<Client> update(Client client);

}
