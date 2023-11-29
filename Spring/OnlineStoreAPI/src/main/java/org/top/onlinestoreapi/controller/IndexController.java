package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.top.onlinestoreapi.entity.goods.Smartphone;
import org.top.onlinestoreapi.service.goods.SmartphoneService;

import java.util.List;

@Controller
public class IndexController {
    private final SmartphoneService smartphoneService;
    public IndexController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @GetMapping("")
    public String index(Model model) {
        Iterable<Smartphone> smartphones = smartphoneService.getAllLimit();
        model.addAttribute("smartphones", smartphones);
        return "index";
    }
}
