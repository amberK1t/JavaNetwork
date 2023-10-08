package org.top.cosinesspringapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.top.cosinesspringapi.message.*;
import org.top.cosinesspringapi.service.Solver;


@RestController
public class AppController {
    private final Solver solver;

    public AppController(Solver solver) {
        this.solver = solver;
    }

    @GetMapping("")
    public StringMessage index() {
        return new StringMessage( "Server is running");
    }

    @GetMapping("/ping")
    public StringMessage ping() {
        return new StringMessage("pong");
    }

    @PostMapping("/solve")
    public Message solver(@RequestBody InputMessage inputMessage) {
        try {
            System.out.println("Received input: " + inputMessage);
            Message solvation = solver.solve(inputMessage);
            System.out.println("Solved: " + solvation);
            return solvation;

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return new ErrorMessage(ex.getMessage());
        }
    }

}
