package com.example.zizonSecurity.controller;

import com.example.zizonSecurity.domain.User;
import com.example.zizonSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/userregform")
    public String userregform() {
        return "/user/userregform";
    }

    @PostMapping("/userreg")
    public String userreg(@ModelAttribute User user, BindingResult result) {
    userService.registUser(user);
    return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "/user/welcome";
    }
}
