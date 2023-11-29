package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.onlinestoreapi.entity.Manufacturer;
import org.top.onlinestoreapi.service.ManufacturerService;

import java.util.Optional;

@Controller
@RequestMapping("manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("")
    public String getAll(Model model) {
        Iterable<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "/manufacturer/manufacturer-list";
    }

    @GetMapping("new")
    public String getNew(Model model) {
        Manufacturer manufacturer = new Manufacturer();
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturer/add-new";
    }

    @PostMapping("new")
    public String postNew(Manufacturer manufacturer, RedirectAttributes redirectAttributes) {
        Optional<Manufacturer> find = manufacturerService.addNew(manufacturer);
        if (find.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Производитель " + find.get() + " успешно добавлен"
            );
        }
        return "redirect:/manufacturer";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Manufacturer> find = manufacturerService.deleteByID(id);
        if (find.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Производитель " + find.get() + " успешно удален");
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Производитель c id " + id + " не найден");
        }
        return "redirect:/manufacturer";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Manufacturer> find = manufacturerService.getById(id);
        if (find.isPresent()) {
            model.addAttribute("manufacturer", find.get());
            return "manufacturer/update";
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Производитель c id " + id + " не найден");
            return "redirect:/manufacturer";
        }
    }

    @PostMapping("/update")
    public String postUpdate(Manufacturer manufacturer, RedirectAttributes redirectAttributes) {
        Optional<Manufacturer> find = manufacturerService.update(manufacturer);
        if (find.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Производитель " + find.get().getName() + " успешно обновлен"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Не получилось выполнить обновление"
            );
        }
        return "redirect:/manufacturer";
    }

    @GetMapping("{id}")
    public String details(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Manufacturer> find = manufacturerService.getById(id);
        if (find.isPresent()) {
            model.addAttribute("manufacturer", find.get());
            return "manufacturer/details";
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Производитель c id " + id + " не найден"
            );
            return "redirect:/manufacturer";
        }
    }


}
