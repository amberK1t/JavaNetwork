package org.top.springmvcexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("time")
    public String time(Model model) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        String formatted = currentTime.format(formatter);
        model.addAttribute("nowTime", formatted);
        return "time";
    }

    @GetMapping("info")
    public String info(Model model) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);
        model.addAttribute("nowDate", formattedDate);

        String osName = System.getProperty("os.name");
        model.addAttribute("sysOs", osName);
        String osVersion = System.getProperty("os.version");
        model.addAttribute("sysVersion", osVersion);
        String osArch = System.getProperty("os.arch");
        model.addAttribute("sysArch", osArch);
        return "info";
    }

}
