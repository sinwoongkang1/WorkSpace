package org.example.springjdbc05;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class Springjdbc05Application {
    public static void main(String[] args) {
        SpringApplication.run(Springjdbc05Application.class, args);
    }
    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {

        String sql = "SELECT id,name,email FROM users";
        User user = jdbcTemplate.query(sql,new UserResultSetExtractor());
            System.out.println(user);
        };
    }

    private static class UserResultSetExtractor implements ResultSetExtractor<User> {
    //ResultSetExtractor => 결과 집합 전체를 단일 객체로 변환 하는데 사용된다
        //특정 조건에 따라 다양한 타입의 객체를 리스트에 추가할 때 사용할 수 있다.
        //메소드가 한 번만 호출돼서 전체 결과를 집합 처리해준다.
        @Override
        public User extractData(ResultSet rs) throws SQLException, DataAccessException {
            User user = new User();
            if(rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
            return user;
        }
    }
}
