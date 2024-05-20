package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @ResponseBody //응답이 페이지가 아니라 데이터구나 (그냥 화면에 리턴값을 보여줌)
    @GetMapping("/rest")
    public String rest(){
        return "rest";
    }
    @GetMapping("greet")
    //http://localhost:8080/greeting?name=kang
    //?name=kang 쿼리문자열 handler adapter가 채워준다  name에 kang 을 넣는걸
    //?name=kang & age=20 하면 다른 매개변수를 이어서 쓴다 (& 이거)
    public String greet(
        @RequestParam String name,
//        @RequestParam(name = "age",required = false) int age,
        Model model){
        System.out.println(name);

        //이때 얻은 값(요청에서 들어오 값)을 컨트롤러도 쓰고, View 도 쓰고, Repository 에서도 써야한다
        //값을 Model 객체에 저장한다 (사실은 scope 를 보면 -> httpServletRequest 객체를 이용하는 것)

        model.addAttribute("name", name);
        return "greet";
    }
    @GetMapping("greeting")
    public ModelAndView greeting(@RequestParam(name = "name",required = false,defaultValue = "world") String name){
        ModelAndView mav = new ModelAndView("greeting");
        mav.addObject("name", name);
        return mav;
    }
}
//