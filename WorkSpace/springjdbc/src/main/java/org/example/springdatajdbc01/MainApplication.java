package org.example.springdatajdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {

//            userRepository.save(new User("kim","kim@gmail.com"));

//            User user =  userRepository.findByName("kang");
//            String kangemail = user.getEmail();
//            System.out.println(kangemail);

            PageRequest pageRequest = PageRequest.of(0, 5);
            Page<User> allUser = userRepository.findAllWithPagination(pageRequest);
            allUser.forEach(System.out::println);


        };
    }
}
