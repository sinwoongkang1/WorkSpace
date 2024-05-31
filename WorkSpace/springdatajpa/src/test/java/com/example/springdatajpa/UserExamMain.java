package com.example.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UserExamMain {
    public static void main(String[] args) {
        SpringApplication.run(UserExamMain.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {

//            User user1 = new User("kang","kang@example.com");
//            userRepository.save(user1);

            List<User> userList= userRepository.findByEmailNative("example");
            for (User user : userList) {
                System.out.println(user.getEmail());
            }
//            System.out.println("More Than age 30:::::::::::::"+userRepository.countOlderThan());

        };
    }
}
