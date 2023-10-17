package org.top.cosinesspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.top.cosinesspringapi.controller.AppController;
import org.top.cosinesspringapi.service.Solver;

@SpringBootApplication
public class CosinesSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosinesSpringApiApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.getBean("solver", Solver.class);
        context.getBean("appController", AppController.class);
    }

}
