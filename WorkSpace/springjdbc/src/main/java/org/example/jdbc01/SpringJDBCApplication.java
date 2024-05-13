package org.example.jdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
          //user 입력
            String sql = "INSERT INTO users (name, email) VALUES (?,?)";
            jdbcTemplate.update(sql,"kang","kang@gmail.com");


        };
    }
}
