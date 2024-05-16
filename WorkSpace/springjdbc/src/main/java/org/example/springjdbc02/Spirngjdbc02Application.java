package org.example.springjdbc02;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spirngjdbc02Application {
    public static void main(String[] args) {
        SpringApplication.run(Spirngjdbc02Application.class, args);

    }
    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
            try {
                userDao.createAndUpdateUser("park", "park@gmail.com", "park@gmail.com");
            }catch(Exception e) {
                e.printStackTrace();
            }
        };
    }
}
