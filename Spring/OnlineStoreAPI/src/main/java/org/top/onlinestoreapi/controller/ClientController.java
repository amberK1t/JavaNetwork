package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.onlinestoreapi.entity.Client;
import org.top.onlinestoreapi.service.ClientService;

import java.util.Optional;

@Controller
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public String getAll(Model model) {
        Iterable<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "client/client-all";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Client> find = clientService.getById(id);
        if (find.isPresent()) {
            model.addAttribute("client", find.get());
            return "client/details";
        }
        else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Клиент с id " + id + " не найден"
                    );
            return "redirect:/client";
        }
    }

    @GetMapping("new")
    public String getNew(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "client/add-new";
    }

    @PostMapping("new")
    public String postNew(Client client, RedirectAttributes redirectAttributes) {
        Optional<Client> add = clientService.add(client);
        if (add.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Клиент " + client.getLogin() + " успешно добавлен");
        }
        return "redirect:/client";
    }

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Client> deleted = clientService.deleteById(id);
        if (deleted.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Клиент с id " + id + " успешно удален");
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Клиент с id " + id + " не найден"
            );
        }
        return "redirect:/client";
    }

    @GetMapping("update/{id}")
    public String getUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Client> find = clientService.getById(id);
        if (find.isPresent()) {
            model.addAttribute("client", find.get());
            return "client/update";
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Клиент с id " + id + " не найден"
            );
            return "redirect:/client";
        }
    }

    @PostMapping("update")
    public String postUpdate(Client client, RedirectAttributes redirectAttributes) {
        Optional<Client> updated = clientService.update(client);
        if (updated.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    " Клиент с id " + client.getId() + " успешно обновлен"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Клиента не получилось обновить"
            );
        }
        return "redirect:/client";
    }

}
