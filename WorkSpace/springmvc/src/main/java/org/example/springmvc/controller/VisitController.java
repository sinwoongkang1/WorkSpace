package org.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {
@GetMapping("/visit")
public String visit(
        @CookieValue(name = "lastVisit",defaultValue = "N/A")String lastVisit,
        HttpServletResponse response,
        Model model){

        Cookie cookie = new Cookie("lastVisit","kang");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);

        model.addAttribute("lastVisit",lastVisit);
    return "visit";
}
}
