package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RoutingController {
    @GetMapping("/start")
    public String start(Model model) {
        model.addAttribute("forwardTest","kkkkkkkk");
        return "forward:/forward";
    }
    @GetMapping("/forward")
    public String forward() {
        return "forwardPage";
    }

    @GetMapping("/redirect")
    public String redirect(Model model) {
        model.addAttribute("finalTest","ttttttttt");
        return "redirect:/final";
    }
    @GetMapping("/final")
    public String finalPage() {
        return "finalPage";
    }
}
