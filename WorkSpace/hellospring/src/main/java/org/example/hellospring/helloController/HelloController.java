package org.example.hellospring.helloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/lotto1")
    public int lotto1() {
        return 16;
    }
    @GetMapping("/lotto2")
    public int lotto2(){
        return 21;
    }@GetMapping("/lotto3")
    public int lotto3() {
        return 43;
    }
}
