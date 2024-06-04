package com.example.restexam.controller;

import com.example.restexam.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {
    @GetMapping("/api/greeting")
    public Map<String, String> greet(@RequestParam(name = "name",required = false,defaultValue = "world") String name) {
    Map<String, String> response = new HashMap<>();
    response.put("key=message", "value = Hello " + name);
    return response;
    }

    @GetMapping(value = "/productjson/{id}",produces = "application/json")
    public Product getProduct(@PathVariable("id") Long id) {
        Product product = new Product(id,"Genesis G90",9678.99);
        return product;
    }

    @GetMapping(value = "/productxml/{id}",produces = "application/xml")
    public Product getProductXml(@PathVariable("id") Long id) {
        Product product = new Product(id,"Genesis G90",9678.99);
        return product;
    }
}
