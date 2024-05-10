package org.example.iocexam;

import org.example.iocexam.config.UserConfig;
import org.example.iocexam.controller.UserController;
import org.example.iocexam.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserRun {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        UserController user = (UserController) context.getBean(UserController.class);
        user.joinUser();

//        user.setEmail("email@email.com");
//        user.setPassword("password");
//        user.setName("kang");


    }
}
