package org.top.onlinestoreapi.rdb;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.Client;
import org.top.onlinestoreapi.entity.Item;
import org.top.onlinestoreapi.entity.Order;
import org.top.onlinestoreapi.entity.Position;
import org.top.onlinestoreapi.rdb.repository.OrderRepository;
import org.top.onlinestoreapi.rdb.repository.PositionRepository;
import org.top.onlinestoreapi.service.ClientService;
import org.top.onlinestoreapi.service.ItemService;
import org.top.onlinestoreapi.service.OrderService;

import java.util.Objects;
import java.util.Optional;

@Service
public class RdbOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final PositionRepository positionRepository;
    private final ClientService clientService;
    private final ItemService itemService;
    public RdbOrderService(OrderRepository orderRepository, PositionRepository positionRepository, ClientService clientService, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.positionRepository = positionRepository;
        this.clientService = clientService;
        this.itemService = itemService;
    }
    @Override
    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<Order> add(Order order) {
        return Optional.of(orderRepository.save(order));
    }

    @Override
    public Optional<Order> update(Order order) {
        Optional<Order> find = orderRepository.findById(order.getId());
        if (find.isPresent()) {
            orderRepository.save(order);
        }
        return find;
    }

    @Override
    public Optional<Order> deleteById(Integer id) {
        Optional<Order> find = orderRepository.findById(id);
        if (find.isPresent()) {
            orderRepository.deleteById(id);
        }
        return find;
    }

    @Override
    public boolean buyItem(Integer itemId, Integer clientId) {
        Optional<Client> client = clientService.getById(clientId);
        if (client.isEmpty()) {
            return false;
        }
        Optional<Item> item = itemService.getById(itemId);
        if (item.isEmpty()) {
            return false;
        }
        Optional<Order> notClosedOrder = findNotClosedOrder(clientId);
        if (notClosedOrder.isPresent()) {
            Optional<Position> position = findPositionByOrderIdAndItemId(notClosedOrder.get().getId(), itemId);
            if (position.isPresent()) {
                position.get().setQuantity(position.get().getQuantity() + 1);
                positionRepository.save(position.get());
            } else {
                Position newPosition = new Position();
                newPosition.setQuantity(1);
                newPosition.setOrder(notClosedOrder.get());
                newPosition.setItem(item.get());
                positionRepository.save(newPosition);
            }
        } else {
            Order newOrder = new Order();
            newOrder.setClient(client.get());
            newOrder = orderRepository.save(newOrder);
            Position position = new Position();
            position.setQuantity(1);
            position.setOrder(newOrder);
            position.setItem(item.get());
            positionRepository.save(position);
        }
        return true;
    }

    @Override
    public Optional<Order> findNotClosedOrder(Integer clientId) {
        Iterable<Order> orders = orderRepository.findAll();
        for (Order order: orders) {
            if (Objects.equals(order.getClient().getId(), clientId) && !order.getClosed()) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Position> findPositionByOrderIdAndItemId(Integer orderId, Integer itemId) {
        Iterable<Position> positions = positionRepository.findAll();
        for (Position position : positions) {
            if (position.getOrder().getId().equals(orderId) && position.getItem().getId().equals(itemId)) {
                return Optional.of(position);
            }
        }
        return Optional.empty();
    }
}
