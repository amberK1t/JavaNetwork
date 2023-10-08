package org.top.cosinesspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class CosinesSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosinesSpringApiApplication.class, args);
    }

}
