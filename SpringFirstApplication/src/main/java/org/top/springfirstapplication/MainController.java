package org.top.springfirstapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("")
    public String index() {
        return "server is running";
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("info")
    public String info() {
        return String.format("OS name - %s\nOS version - %s\nOS Architecture - %s",
                System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("os.arch"));

    }

}
