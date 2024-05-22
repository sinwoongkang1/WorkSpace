package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyViewController {
    @GetMapping("/custom")
    public String custom() {
        return "myView-custom";
    }
}
