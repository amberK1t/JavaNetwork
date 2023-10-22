package org.top.productsandordersapiapp.rdb.service;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Client;
import org.top.productsandordersapiapp.entity.Order;
import org.top.productsandordersapiapp.rdb.repository.OrderRepository;
import org.top.productsandordersapiapp.service.ClientService;
import org.top.productsandordersapiapp.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class RdbOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ClientService clientService;

    public RdbOrderService(OrderRepository orderRepository, ClientService clientService) {
        this.orderRepository = orderRepository;
        this.clientService = clientService;

    }


    @Override
    public Optional<Order> add(Order order) {
        // достанем id клиента
        Integer clientId = order.getClient().getId();
        // попробуем найти клиента с таким id
        Optional<Client> client = clientService.getById(clientId);
        if (client.isPresent()) {
            return Optional.of(orderRepository.save(order));
        }
       return Optional.empty();
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> getByOrderId(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllByClientId(Integer clientId) {
        return (List<Order>) orderRepository.findAllByClientId(clientId);
    }

    @Override
    public Optional<Order> updateDescription(Integer id, String description) {
        Optional<Order> order = getByOrderId(id);
        if (order.isPresent()) {
            order.get().setDescription(description);
            orderRepository.save(order.get());
        }
        return order;
    }
}
