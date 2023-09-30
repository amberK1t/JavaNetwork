package org.top.springfirstapplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @PostMapping("post-calc")
    public String calc(@RequestParam Double x, @RequestParam Double y) {
        if (x < 0 || y < 0) {
            return "Вы ввели некорректные данные";
        }
        return String.format("x = %.3f, y = %.3f, гипотенуза = %.3f", x, y, Math.sqrt(x*x + y*y));
    }
}
