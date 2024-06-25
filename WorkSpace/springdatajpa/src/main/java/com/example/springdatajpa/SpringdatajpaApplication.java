package com.example.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringdatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }
//@Bean
//    public CommandLineRunner run(UserRepository repository){
//        return args -> {
//            //create
////            User user = new User("John","john@gmail.com");
////            repository.save(user);
////            //delete
////            repository.delete(user);
////
////            List<User> user1 = repository.findByName("John");
////            for (User user2 : user1) {
////                System.out.println(user2.getEmail());
////            }
////
////            List<User> user2 = repository.findByEmail("john@gmail.com");
////            for (User user3 : user2) {
////                System.out.println(user3.getName());
//            }
//
//            repository.deleteByEmail("john@gmail.com");
//        };
//}

}
