package org.example.springmvc.controller;

import jakarta.validation.Valid;
import org.example.springmvc.domain.User;
import org.example.springmvc.domain.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
@GetMapping("form")
    public String form(Model model) {
    model.addAttribute("userForm",new UserForm());
    return "form";
}
//@PostMapping("/submitForm")
//    public String submitForm(
//            @RequestParam String username,
//            @RequestParam String password){
//    System.out.println(username+"::"+password);
//    return "result";
//}
//}
@PostMapping("/submitForm")
public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result){
    if (result.hasErrors()) {
        return "form"; //유효성 감사에서 에러 발견시 form view로 리턴
    }
    return "result"; //에러가 없다면 result view로 리턴
}
}