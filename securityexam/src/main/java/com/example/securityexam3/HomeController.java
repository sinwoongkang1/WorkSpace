package com.example.securityexam3;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Home";
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/success")
    public String hi() {
        return "success";
    }
    @GetMapping("/user")
    public String user() {
        return "user";
    }
    @GetMapping("/test")
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.isAuthenticated());
        if(authentication==null || !authentication.isAuthenticated() || authentication.getPrincipal() instanceof String) {
            return "익명 사용자";
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "사용자 : "+userDetails.getUsername();
    }
    @GetMapping("/both")
    public String both() {
        return "both";
    }

    @GetMapping("/mypages")
    public String mypage(@AuthenticationPrincipal UserDetails userDetails) {
        return "userName : " + userDetails.getUsername();
    }
}
