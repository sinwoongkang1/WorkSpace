package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("hi")
    public String hi(){
        return "hi";
    }
    @GetMapping("/nihao")
    public String nihao(){
        return "nihao";
    }
}
