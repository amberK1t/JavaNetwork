package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.onlinestoreapi.entity.Order;
import org.top.onlinestoreapi.service.OrderService;

import java.util.Optional;

@Controller
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public String getAll(Model model) {
        Iterable<Order> orders = orderService.getAll();
        model.addAttribute("orders", orders);
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
}
