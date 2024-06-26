package com.example.securityexam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Home";
    }
    @GetMapping("/loginform")
    public String hello() {
        return "hello";
    }
    @GetMapping("/success")
    public String hi() {
        return "success";
    }
}
