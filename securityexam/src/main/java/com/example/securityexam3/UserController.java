package com.example.securityexam3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/mypage")
    public String myPage() {
        return "mypage";
    }
}
