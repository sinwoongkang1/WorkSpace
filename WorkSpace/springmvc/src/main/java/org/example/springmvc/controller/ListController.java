package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ListController {
    @GetMapping("list")
    public String list(Model model) {
        List<String> list = Arrays.asList(
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"
        );
        model.addAttribute("list", list);
        return "list";
    }
}
