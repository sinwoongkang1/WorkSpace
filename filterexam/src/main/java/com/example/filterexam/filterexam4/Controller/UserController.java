package com.example.filterexam.filterexam4.Controller;

import com.example.filterexam.filterexam4.entitiy.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/loginform")
    public String loginForm(){
        return "loginform";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpServletResponse response, Model model){
        return "welcome";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @GetMapping("/info")
    public String info(){
        return "info";
    }
    //쿠키는 같은 값을 가질 수 없기 때문에, 같은 이름의, 유지시간이 0인 쿠키를 한 번 보내주면 없어져버린다.
    @GetMapping("/logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setMaxAge(0); //쿠키 유지시간을 0으로
        response.addCookie(cookie);
        return "loginform";
    }
}
