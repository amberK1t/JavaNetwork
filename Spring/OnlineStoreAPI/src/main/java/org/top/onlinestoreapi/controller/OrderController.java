package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.onlinestoreapi.entity.Client;
import org.top.onlinestoreapi.entity.Item;
import org.top.onlinestoreapi.entity.Order;
import org.top.onlinestoreapi.entity.Position;
import org.top.onlinestoreapi.service.ClientService;
import org.top.onlinestoreapi.service.ItemService;
import org.top.onlinestoreapi.service.OrderService;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;
    private final ClientService clientService;
    private final ItemService itemService;
    public OrderController(OrderService orderService, ClientService clientService, ItemService itemService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.itemService = itemService;
    }

    @GetMapping("")
    public String getAll(Model model, Principal principal, RedirectAttributes ra) {
        Optional<Client> client = clientService.findClientByUserLogin(principal.getName());
        if (client.isEmpty()) {
            ra.addFlashAttribute(
                    "dangerMessage",
                    "Ошибка покупки, пользователь не найден"
            );
        } else {
            Iterable<Order> closedOrders = orderService.findAllClosedOrders(client.get().getId());
            Optional<Order> notClosedOrder = orderService.findNotClosedOrder(client.get().getId());
            if (notClosedOrder.isPresent()) {
                double total = 0.0;
                for (Position position: notClosedOrder.get().getPositionSet()) {
                    total += position.getItem().getPrice() * position.getQuantity();
                }
                model.addAttribute("total", total);
            }

            model.addAttribute("closedOrders", closedOrders);
            model.addAttribute("notClosedOrders", notClosedOrder.orElse(null));
        }
        return "order/order-all";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Order> find = orderService.getById(id);
        if (find.isPresent()) {
            model.addAttribute("order", find.get());
            return "order/details";
        }
        else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Заказ с id " + id + " не найден"
            );
            return "redirect:/order";
        }
    }

    @GetMapping("new")
    public String getNew(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "order/add-new";
    }

    @PostMapping("new")
    public String postNew(Order order, RedirectAttributes redirectAttributes) {
        Optional<Order> add = orderService.add(order);
        if (add.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Заказ с id " + order.getId() + " успешно добавлен");
        }
        return "redirect:/order";
    }

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Order> deleted = orderService.deleteById(id);
        if (deleted.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Заказ с id " + id + " успешно удален");
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Заказ с id " + id + " не найден"
            );
        }
        return "redirect:/order";
    }

    @GetMapping("update/{id}")
    public String getUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Order> find = orderService.getById(id);
        if (find.isPresent()) {
            model.addAttribute("order", find.get());
            return "order/update";
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Заказ с id " + id + " не найден"
            );
            return "redirect:/order";
        }
    }

    @PostMapping("update")
    public String postUpdate(Order order, RedirectAttributes redirectAttributes) {
        Optional<Order> updated = orderService.update(order);
        if (updated.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    " Заказ с id " + order.getId() + " успешно обновлен"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Заказ не получилось обновить"
            );
        }
        return "redirect:/order";
    }

    @GetMapping("buy/{itemId}")
    public String buy(@PathVariable Integer itemId, Principal principal, RedirectAttributes ra) {
        Optional<Client> client = clientService.findClientByUserLogin(principal.getName());
        if (client.isPresent()) {
            orderService.buyItem(itemId, client.get().getId());
            Optional<Item> item = itemService.getById(itemId);
            if (item.isPresent()) {
                String type = item.get().getType();
                switch (type) {
                    case "smartphone":
                        return "redirect:/item/smartphone";
                    case "tv":
                        return "redirect:/item/tv";
                    case "laptop":
                        return "redirect:/item/laptop";
                }
            } else {
                ra.addFlashAttribute(
                        "dangerMessage",
                        "Item не найден"
                );
            }
        } else {
            ra.addFlashAttribute(
                    "dangerMessage",
                    "Ошибка покупки, пользователь не найден"
            );
        }
        return "redirect:/item";
    }

    @GetMapping("complete/{orderId}")
    public String complete(@PathVariable Integer orderId, RedirectAttributes ra) {
        try {
            orderService.closedOrder(orderId);
        } catch (Exception e) {
            ra.addFlashAttribute(
                    "dangerMessage",
                    "Ошибка подтверждения заказа"
            );
        }
        return "redirect:/order";
    }

    @GetMapping("add-item/{positionId}")
    public String addItem(@PathVariable Integer positionId, RedirectAttributes ra) {
        try {
            orderService.addItem(positionId);
        } catch (Exception e) {
            ra.addFlashAttribute(
                    "dangerMessage",
                    "Ошибка увеличения количества " + e.getMessage()
            );
        }
        return "redirect:/order";
    }

    @GetMapping("remove-item/{positionId}")
    public String removeItem(@PathVariable Integer positionId, RedirectAttributes ra) {
        try {
            orderService.removeItem(positionId);
        } catch (Exception e) {
            ra.addFlashAttribute(
                    "dangerMessage",
                    "Ошибка уменьшения количества " + e.getMessage()
            );
        }
        return "redirect:/order";
    }

}
