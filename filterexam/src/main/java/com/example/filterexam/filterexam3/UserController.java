package com.example.filterexam.filterexam3;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        User user = UserContext.getUser();
        if (user != null) {
            return "welcome";
        }else
            return "redirect:/loginform";

    }

    //로그인 한 사용자에게만 보여주는 페이지
    @GetMapping("/info")
    public String info(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies(); //요청이 들어오면 거기서 쿠키들을 보자
        String auth = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth")) {
                    auth = cookie.getValue();
                    break;
                }
            }
        }
        if (auth != null) {
            return "info";
        }else
            return "redirect:/loginform";

    }
}
