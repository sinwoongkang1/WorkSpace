package com.example.restexam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ExceptionController {
@GetMapping("/api/error")
    public String error() {
    throw new RuntimeException(" API error");
}
}
