package org.top.springfirstapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ParametersExampleController {

    @GetMapping("get-test")
    public String getTest(@RequestParam Integer a, @RequestParam Integer b) {
        return "received params: a = " + a + " b = " + b;
    }
}
