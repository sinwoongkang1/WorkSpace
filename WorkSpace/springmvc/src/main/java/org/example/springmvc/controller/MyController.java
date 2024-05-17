package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//내가 컨트롤러임 -> view 를 리턴 (RestController 는 데이터를 리턴해줌->화면에 home 나옴(message Convertor 사용해서 데이터를 보여줌))
public class MyController {
    @GetMapping("/home")
    public String name(){
        return "home"; //"home" -? 이게 View Name 이다.
        //timeLeaf 에 view리졸버가 설정에 들어가서 Template 폴더 밑에 "home"과 같은 이름의 html 로 연결한다.
        //TimeLeaf 를 추가한 것 -> View Resolver 가 생긴 것.
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/help")
    public String help(){
        return "help";
    }
}
//