package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.top.onlinestoreapi.entity.Item;
import org.top.onlinestoreapi.service.ItemService;

@Controller
public class IndexController {
    private final ItemService itemService;
    public IndexController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public String index(Model model) {
        Iterable<Item> smartphones = itemService.getAllLimit("smartphone");
        Iterable<Item> tvs = itemService.getAllLimit("tv");
        Iterable<Item> laptops = itemService.getAllLimit("laptop");
//        if (smartphones != null && tvs != null && laptops != null) {
            model.addAttribute("smartphones", smartphones);
            model.addAttribute("tvs", tvs);
            model.addAttribute("laptops", laptops);
//        } else {
//            model.addAttribute("dangerMessage", "oops");
//        }
        return "index";
    }
}
