package org.example.springjdbc08;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    //입력이 되면 자동으로 생성된 Primary Key 값을 리턴 받고 싶다.
    //SimpleJdbcInsert 객체를 이용해야 한다.
    private SimpleJdbcInsert simpleJdbcInsert;
    @PostConstruct
    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user").usingGeneratedKeyColumns("id");
    }

    public User insertUser(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("name",user.getName());
        params.put("email",user.getEmail());
        Number pk = simpleJdbcInsert.executeAndReturnKey(params);
        user.setId(pk.longValue());
        return user;


    }
}
