package org.top.jsonapiexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.top.jsonapiexample.message.*;
import org.top.jsonapiexample.service.Solver;
import org.top.jsonapiexample.service.StandardSolver;

// Контроллер принимающий и обрабатывающий запросы, отправляющий ответы
@RestController
public class ApplicationController {

    // внедрить зависимость Solver
    private final Solver solver;

    // DI в действии
    public ApplicationController(Solver solver) {
        this.solver = solver;
    }

    @GetMapping("")
    public Message index() {
        return new StringMessage("Server is running");
    }

    @GetMapping("ping")
    public Message ping() {
        return new StringMessage("pong");
    }

    @PostMapping("solve")
    public Message solve(@RequestBody InputMessage inputMessage) {
        try {
            System.out.println("Received input: " + inputMessage);
            // использование зависимости solver
            OutputMessage solvation = solver.solve(inputMessage);
            System.out.println("Solved: " + solvation);
            return solvation;

        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return new ErrorMessage(ex.getMessage());
        }
    }
}
