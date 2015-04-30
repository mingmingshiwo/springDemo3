package com.rongzm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class Example {

    @Value("${my.name}")
    private String name;

    @Value("${my.randNum}")
    private int randNum;

    @Autowired
    private Config config;

    @RequestMapping("/")
    String home() {
        return "Hello World!" + name + randNum + config.getServers();
    }

    @RequestMapping("/exp")
    String exp(){
        if(randNum < Long.MAX_VALUE){
            throw new RuntimeException();
        }
        return "never return this";
    }
}