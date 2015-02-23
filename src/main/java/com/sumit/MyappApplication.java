package com.sumit;

import com.sumit.model.*;
import com.sumit.model.Character;
import com.sumit.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MyappApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyappApplication.class, args);

    }
}
