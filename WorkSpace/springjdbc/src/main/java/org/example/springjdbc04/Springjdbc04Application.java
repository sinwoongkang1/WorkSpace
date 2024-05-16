package org.example.springjdbc04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Springjdbc04Application {
    public static void main(String[] args) {
        SpringApplication.run(Springjdbc04Application.class, args);
    }
    private static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
           Long id = rs.getLong("id");
           String name = rs.getString("name");
           String email = rs.getString("email");
           return new User(id, name, email);
        }
    }
    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
            String sql = "Select id, name, email from users";
            List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
            users.forEach(System.out::println);
        };
    }
}
