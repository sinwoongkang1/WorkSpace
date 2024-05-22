package org.example.springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
//애노테이션으로 session 을 이용한 예
@SessionAttributes("visitCount2") //visitCount2을 세션에 저장
public class SessionController {
    //세션 초기화
    @ModelAttribute("visitCount2")
    public int getVisitCount2() {
        return 0;
    }
    @GetMapping("/visit2") //ModelAttribute 로 visitCount2을 찾아온다
    public String trackVisit(@ModelAttribute("visitCount2")Integer visitCount2, Model model) {
        visitCount2++;
        model.addAttribute("visitCount2", visitCount2);
        return "visit2";
    }

    //세션 전체 삭제
    @GetMapping("/resetVisit")
    public String resetVisit(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/visit2";
    }

//    //세션에서 특성 속성만 삭제
//    @GetMapping("/resetVisit")
//    public String resetVisit(HttpSession session) {
//        session.removeAttribute("visitCount2");
//        return "redirect:/visit2";
//    }


}

    //httpSession 을 이용한 예 session에 값을 직접 지정하고 꺼내오는 것
//    @GetMapping("/visit2")
//    public String trackVisit(HttpSession session) {
//        //세션으로 부터 방문 횟수를 얻어온다
//      Integer visitCount = (Integer) session.getAttribute("visitCount");
//      if (visitCount == null) {
//          visitCount = 0;
//      }
//      visitCount++;
//      session.setAttribute("visitCount", visitCount); //타임리프에서 꺼낼 키, 실제 참조값
//        return "visit2";
//    }
//}



