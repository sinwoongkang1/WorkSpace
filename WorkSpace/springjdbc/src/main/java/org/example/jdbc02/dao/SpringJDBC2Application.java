package org.example.jdbc02.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringJDBC2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
//          userDao.insertUser(new User(null,"kang","kang@email.com"));
//          userDao.insertUser(new User(null,"jung","jung@email.com"));
//          userDao.updateUserEmail("son","son@gmail.com");
//          userDao.deleteUser("kang");
            List<User> user = userDao.findAllUsers();
            user.forEach(System.out::println);

        };
    }
}
