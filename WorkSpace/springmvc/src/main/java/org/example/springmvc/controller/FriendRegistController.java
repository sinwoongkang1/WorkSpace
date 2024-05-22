package org.example.springmvc.controller;

import org.example.springmvc.domain.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("friendList")
public class FriendRegistController {

    @GetMapping("/regist")
    public String regist() {
        return "regist";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("nickname") String nickname,
            Model model) {

        List<Friend> friendList = (List<Friend>) model.getAttribute("friendList");
        if (friendList == null) {
            friendList = new ArrayList<>();
        }

        friendList.add(new Friend(name, email, nickname));
        model.addAttribute("friendList", friendList);

        System.out.println(name);
        System.out.println(email);
        System.out.println(nickname);

        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Friend> friendList = (List<Friend>) model.getAttribute("friendList");
        model.addAttribute("friendList", friendList);
        return "index";
    }

    @GetMapping("/friendList")
    public String viewFriends(Model model) {
        List<Friend> friendList = (List<Friend>) model.getAttribute("friendList");
        model.addAttribute("friendList", friendList);
        return "friendList";
    }
}
