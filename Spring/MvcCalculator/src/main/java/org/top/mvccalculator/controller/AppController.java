package org.top.mvccalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.top.mvccalculator.service.InputData;
import org.top.mvccalculator.service.Solution;
import org.top.mvccalculator.service.CosinesTheoremSolver;

@Controller
public class AppController {

    private final CosinesTheoremSolver solver;
    public AppController(CosinesTheoremSolver solver) {
        this.solver = solver;
    }

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("calculator")
    public String calc(Model model) {
        InputData emptyInput = new InputData(1.0, 1.0, 30.0, "град");
        model.addAttribute("input", emptyInput);
        return "calculator";
    }

    @PostMapping("solve")
    public String solve(InputData inputData, Model model) {
        System.out.println("> получены данные - " + inputData);
            try {
                Solution solution = solver.solve(inputData);
                System.out.println("> получено решение - " + solution);
                model.addAttribute("input", inputData);
                if (solution.getRequiredSide().contains("числа")) {
                    model.addAttribute("wrongData", solution);
                } else {
                    model.addAttribute("solution", solution);
                }
            } catch (Exception ex) {
                System.out.println("> ERROR: " + ex.getMessage());
                model.addAttribute("errorMessage", ex.getMessage());
            }
        return "calculator";
    }
}
