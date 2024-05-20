package org.example.springmvc.controller;

import org.example.springmvc.domain.Item;
import org.example.springmvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExamController {
    @GetMapping("welcome")
    public String welcome(Model model) {

        model.addAttribute("welcomeMsg","환영합니다");
//model (추가할 이름, 실제 그 객체) 추가할 이름 = 맡길이름, 찾을이름
        List<Item> items = Arrays.asList(
                new Item("pen",3000),
                new Item("note",5000),
                new Item("glass",7000)
        );

        model.addAttribute("items",items);

        return "welcome";
    }

    @GetMapping("fruit")
    public String index(Model model) {
        model.addAttribute("first","Welcome Fruits Page");
         List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1, "Apple", 1.20),
                new Product(2, "Banana", 0.75),
                new Product(3, "Cherry", 2.05)
        ));
         model.addAttribute("products",products);
         return "Fruits";
    }

    @GetMapping("example")
    public String example(Model model) {

        model.addAttribute("username","S.W.KANG");
        model.addAttribute("inAdmin",false);
        model.addAttribute("languages",new String[]{"Java","Python"});

        return "exam";
    }
}
