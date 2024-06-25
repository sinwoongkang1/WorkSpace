package com.example.filterexam.filterexam2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController// 데이터를 그냥 전달해주는 컨트롤러임.
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/")
    public String home() {
        log.info("home 실행");
        return "home";
    }
    @GetMapping("/hi")
    public String hi() {
        User user = UserContext.getUser();
        log.info("hi 실행" + user);
        return "hi";
    }
    @GetMapping("/hello")
    public String hello() {
        userService.list();
        log.info("hello 실행");
        return "hello";
    }
}
