package com.example.tinexchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TinexChainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinexChainApplication.class, args);
    }

}
