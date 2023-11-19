package org.top.hotelscatalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.hotelscatalog.entity.Hotel;
import org.top.hotelscatalog.service.HotelService;

import java.util.Optional;

// HotelController - контроллер для работы с отелями
@Controller
@RequestMapping("hotel")
public class HotelController {

    // сервис для работы с отелями
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Обработчик получения всех объектов
    // http://localhost:8080/hotel
    @GetMapping("")
    public String getAll(Model model) {
        Iterable<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        return "hotel/hotel-list";
    }

    // Обработчики добавление объекта
    // первый получает форму, второй обрабатывает
    // http://localhost:8080/hotel/new
    @GetMapping("new")
    public String getAddForm(Model model) {
        Hotel hotel = new Hotel(); // объект для заполнения в форме
        model.addAttribute("hotel", hotel);
        return "hotel/add-hotel-form";
    }

    @PostMapping("new")
    public String postAddForm(Hotel hotel, RedirectAttributes redirectAttributes) {
        Optional<Hotel> saved = hotelService.save(hotel);
        if (saved.isPresent()) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Отель " + saved.get() + " успешно добавлен");
        }
        // перенаправление запроса
        return "redirect:/hotel";
    }

    // Обработчик удаления объекта
    // http://localhost:8080/hotel/delete/{id}
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Hotel> deleted = hotelService.deleteById(id);
        if (deleted.isPresent()) {
            // запишем сообщение, что успешно удален
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Отель " + deleted.get() + " успешно удален");
        } else {
            // запишем сообщение, что не найден такой
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Отель с id " + id + " не найден"
            );
        }
        return "redirect:/hotel";
    }

    // Обработчики редактирования объекта
    // Первый возвращает форму, второй обрабатывает
    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Hotel> updated = hotelService.findById(id);
        if (updated.isPresent()) {
            model.addAttribute("hotel", updated.get());
            return "hotel/update-hotel-form";
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Отель с id " + id + " не найден");
            return "redirect:/hotel";
        }
    }

    @PostMapping("/update")
    public String postUpdateForm(Hotel hotel, RedirectAttributes redirectAttributes) {
        Optional<Hotel> updated = hotelService.update(hotel);
        if (updated.isPresent()) {
            // запишем сообщение, что успешно обновлен
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Отель " + updated.get() + " успешно обновлен");
        } else {
            // запишем сообщение, что не получилось обновить
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Не получилось выполнить обновление"
            );
        }
        return "redirect:/hotel";
    }

    // Вывод информации об одном отеле (подробной)
    @GetMapping("{id}")
    public String details(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Hotel> hotel = hotelService.findById(id);
        if (hotel.isPresent()) {
            model.addAttribute("hotel", hotel);
            return "hotel/hotel-details";
        } else {
            redirectAttributes.addFlashAttribute(
                    "dangerMessage",
                    "Отель с id " + id + " не найден");
            return "redirect:/hotel";
        }
    }
}
