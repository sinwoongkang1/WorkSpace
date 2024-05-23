package org.example.friendexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.service.FriendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
   private final FriendService friendService;

//   @GetMapping
//   public String friends(Model model) {
//       Iterable friend;
//       friend= friendService.findAllFriends();
//       model.addAttribute("friends", friend);
//       return "friends/list";
//   }
@GetMapping
public String friends(Model model,@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "5") int size){
    Pageable pageable = PageRequest.of(page - 1, size);
    Page<Friend> friend= friendService.findAllFriends(pageable);
    model.addAttribute("friends", friend);
    model.addAttribute("currentPage", page);
    return "friends/list";
}

   @GetMapping("/add")
    public String addFriend(Model model) {
       model.addAttribute("friend", new Friend());
       return "friends/addForm";
   }
   @PostMapping("/add")
    public String addFriend(@ModelAttribute("friend") Friend friend,
                            RedirectAttributes redirectAttributes) {
       friendService.saveFriend(friend);
       redirectAttributes.addFlashAttribute("message", "친구가 등록되었습니다");
       return "redirect:/friends";
   }

   //친구상세페이지
   @GetMapping("/{id}")
    public String FriendDetails(@PathVariable Long id, Model model){
       Friend friend = friendService.findFriendById(id);
       model.addAttribute("friend", friend);
       return "friends/details";
   }

   @GetMapping("/delete/{id}")
    public String deleteFriend(@PathVariable Long id) {
       friendService.deleteFriendById(id);
       return "redirect:/friends";
   }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        model.addAttribute("friend", friendService.findFriendById(id));
        return "friends/edit";
    }

    @PostMapping("/edit")
    public String editFriend(@ModelAttribute Friend friend){
        friendService.saveFriend(friend);
        return "redirect:/friends";
    }

}
