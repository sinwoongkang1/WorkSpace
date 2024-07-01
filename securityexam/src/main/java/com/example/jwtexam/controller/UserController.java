package com.example.jwtexam.controller;

import com.example.jwtexam.domain.User;
import com.example.jwtexam.service.UserService;
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
