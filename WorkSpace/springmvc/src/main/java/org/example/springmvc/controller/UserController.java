package org.example.springmvc.controller;

import org.example.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("user")
    public String user(Model model) {
        List<User> users = Arrays.asList(
                new User("Heungmin Son",true),
                new User("kangin Lee", false),
                new User("Minjae Kim", true)
        );
        model.addAttribute("users", users);
        return "user";
    }
}
