package com.example.filterexam.filterexam1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController// 데이터를 그냥 전달해주는 컨트롤러임.
public class HomeController {
    @GetMapping("/aaaaaaaa")
    public String home() {
        log.info("home 실행");
        return "home";
    }
    @GetMapping("/asdfasdfas")
    public String hi() {
        log.info("hi 실행");
        return "hi";
    }
}
