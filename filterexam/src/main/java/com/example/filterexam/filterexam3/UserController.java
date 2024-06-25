package com.example.filterexam.filterexam3;

import com.example.filterexam.filterexam2.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @GetMapping("/loginform")
    public String loginForm() {
        return "loginform";
    }
    @PostMapping("/login")
    public String loginForm(@ModelAttribute("user") User user, HttpServletResponse response) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        if (user.getUsername().equals("kkace22") && user.getPassword().equals("asdf")) {
            Cookie cookie = new Cookie("auth", "kang");
            cookie.setPath("/"); //루트로 지정, 어디서나 유효함
            //생성된 쿠키는 클라이언트에게 보내야 함(응답에 실어 보낸다)
            response.addCookie(cookie);
        }

        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
