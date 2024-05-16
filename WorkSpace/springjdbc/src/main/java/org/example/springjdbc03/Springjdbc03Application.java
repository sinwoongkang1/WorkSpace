package org.example.springjdbc03;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springjdbc03Application {
    public static void main(String[] args) {
        SpringApplication.run(Springjdbc03Application.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserService userService ) {
        return args -> {

            try{
                userService.executeComplexBusinessProcess("James","error@example.com");
            }catch(Exception e){{
            e.printStackTrace();}
            }
        };
    }
}
