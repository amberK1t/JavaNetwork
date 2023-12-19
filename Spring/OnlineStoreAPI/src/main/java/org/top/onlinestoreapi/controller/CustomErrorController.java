package org.top.onlinestoreapi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String error(HttpServletRequest request, Model model) {
        Object reqStatus = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (reqStatus == null) {
            model.addAttribute("status", "Error");
            model.addAttribute("message", "Error");
            return "error";
        }
        int statusCode = Integer.parseInt(reqStatus.toString());
        String status = "";
        String message = "";

        switch (statusCode) {
            case 404 -> {
                status = "404 Not Found";
                message = "Такой страницы нет";
            }
            case 403 -> {
                status = "403 Forbidden";
                message = "Нет доступа";
            }
            case 400 -> {
                status = "400 Bad request";
                message = "Некорректный запрос";
            }
            case 500, 501, 502, 503, 504, 505 -> {
                status = "5** Server Error";
                message = "Ошибка сервера";
            }
        }
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        return "error";
    }

}
