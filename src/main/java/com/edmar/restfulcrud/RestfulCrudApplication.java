package com.edmar.restfulcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class RestfulCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulCrudApplication.class, args);
    }


}
