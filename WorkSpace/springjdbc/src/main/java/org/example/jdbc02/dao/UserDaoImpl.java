package org.example.jdbc02.dao;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {
    // 직접구현이 아니라 JdbcTemplate 객체를 이용해서 구현할 것
    // DI를 어떻게 할까?? 3개중 하나로(생성자,설정자,필드기반)
    // @RequiredArgsConstructor -> final 이 붙은 필드에 대해 생성자를 만들어준다.

    private final JdbcTemplate jdbcTemplate;


    @Override
    public void insertUser(User user) {
    jdbcTemplate.update("INSERT INTO users(name, email) values(?, ?)", user.getName(), user.getEmail());
    }

    @Override
    public List<User> findAllUsers() {
        RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
        );
        List<User> users = jdbcTemplate.query("SELECT * FROM users", rowMapper);
        return users;
    }

    @Override
    public void updateUserEmail(String name, String email) {
    jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?", email, name);
    }

    @Override
    public void deleteUser(String name) {
    jdbcTemplate.update("DELETE FROM users WHERE name = ?", name);
    }
}
