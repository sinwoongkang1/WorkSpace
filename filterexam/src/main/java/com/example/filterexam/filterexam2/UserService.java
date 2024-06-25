package com.example.filterexam.filterexam2;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void list(){
        //user 가 있다면 실행될 것.
        User user = UserContext.getUser();
        System.out.println(user);
    }
}
