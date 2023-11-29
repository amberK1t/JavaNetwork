package org.top.onlinestoreapi.controller.goods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.onlinestoreapi.entity.goods.Smartphone;
import org.top.onlinestoreapi.service.goods.SmartphoneService;

import java.util.Optional;

@Controller
@RequestMapping("smartphone")
public class SmartphoneController {

    private final SmartphoneService smartphoneService;
    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @GetMapping("")
    public String getAll(Model model) {
        Iterable<Smartphone> smartphones = smartphoneService.getAll();
        model.addAttribute("smartphones", smartphones);
        return "goods/smartphone/smart-all";
    }

    @GetMapping("new")
    public String getNew(Model model) {
        Smartphone smartphone = new Smartphone();
        model.addAttribute("smartphone", smartphone);
        return "goods/smartphone/add-new";
    }

    @PostMapping("new")
    public String postNew(Smartphone smartphone, RedirectAttributes redirectAttributes) {
        Optional<Smartphone> add = smartphoneService.addNew(smartphone);
        if (add.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Смартфон " + add.get().getName() + " успешно добавлен"
                    );
        }
        return "redirect:/smartphone";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Smartphone> deleted = smartphoneService.deleteById(id);
        if (deleted.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Смартфон " + deleted.get() + " успешно удален"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Смартфон с id " + id + " не найден"
            );
        }
        return "redirect:/smartphone";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Smartphone> updated = smartphoneService.getById(id);
        if (updated.isPresent()) {
            model.addAttribute("smartphone", updated.get());
            return "goods/smartphone/update";
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Смартфон с id " + id + " не найден"
            );
            return "redirect:/smartphone";
        }
    }

    @PostMapping("/update")
    public String postUpdate(Smartphone smartphone, RedirectAttributes redirectAttributes) {
        Optional<Smartphone> updated = smartphoneService.update(smartphone);
        if (updated.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Смартфон " + updated.get().getName() + " успешно обновлен"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Смартфон не получилось обновить"
            );
        }
        return "redirect:/smartphone";
    }

}
