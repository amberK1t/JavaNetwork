package org.top.onlinestoreapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.onlinestoreapi.form.UserRegistrationForm;
import org.top.onlinestoreapi.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("register")
    public String getRegistrationForm(Model model) {
        UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
        model.addAttribute("userRegistrationForm", userRegistrationForm);
        return "register-form";
    }

    @PostMapping("register")
    public String postRegistrationForm(UserRegistrationForm userRegistrationForm, RedirectAttributes ra) {
        userRegistrationForm.setRole("USER");
        if (userService.register(userRegistrationForm)) {
            return "redirect:/login";
        }
        ra.addFlashAttribute("dangerMessage",
                "Не удалось зарегистрироваться");
        return "redirect:/user/register";
    }
}
