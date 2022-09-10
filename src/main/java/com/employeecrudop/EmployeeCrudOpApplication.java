package com.employeecrudop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmployeeCrudOpApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeCrudOpApplication.class, args);
    }

}
