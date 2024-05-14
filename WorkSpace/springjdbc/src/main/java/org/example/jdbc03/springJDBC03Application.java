package org.example.jdbc03;


import org.example.jdbc03.dao.User;
import org.example.jdbc03.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class springJDBC03Application {
    public static void main(String[] args) {
        SpringApplication.run(springJDBC03Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
//          userDao.insertUser(new User(null,"kang","kang@email.com"));
//          userDao.insertUser(new User(null,"jung","jung@email.com"));
//          userDao.updateUserEmail("son","son@gmail.com");
          userDao.deleteUser("hang");
//            List<User> user = userDao.findAllUsers();
//            user.forEach(System.out::println);

        };
    }
}
