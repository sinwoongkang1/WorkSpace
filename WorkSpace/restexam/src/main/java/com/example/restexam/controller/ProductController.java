package com.example.restexam.controller;

import com.example.restexam.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final Map<Long, Product> products = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    //Read
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return products.get(id);
    }
    @GetMapping
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    //Create
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        Long id =  idGenerator.incrementAndGet();
        product.setId(id);
        products.put(id, product);
        return product;
    }
    //Update
    @PutMapping("/{id}")
    public Product UpdateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product oldProduct = products.get(id);
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        return oldProduct;
    }
    //Delete
    @DeleteMapping("/{id}")
    public String DeleteProduct(@PathVariable Long id) {
        products.remove(id);
        return "Product deleted";
    }
}
