package org.example.jdbc03.dao;

import lombok.RequiredArgsConstructor;
import org.example.jdbc03.UserNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
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
        try {
            jdbcTemplate.update("INSERT INTO users(name, email) values(?, ?)", user.getName(), user.getEmail());
        }catch (DataAccessException e) {
            throw new DataAccessException("사용자를 입력하다가 오류 발생"+ user.getName(),e) {
            };
        }

    }

    @Override
    public List<User> findAllUsers() {
        try{RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("email")
    );
        List<User> users = jdbcTemplate.query("SELECT * FROM users", rowMapper);
        return users;
    }catch (DataAccessException e) {
        throw new DataAccessException("사용자 목록을 조회할 수 없음",e) {
        };
    }

    }

    @Override
    public void updateUserEmail(String name, String email) {
        int update ;
    update = jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?", email, name);
    if (update == 0) {
        throw new UserNotFoundException("해당 사용자의 이메일을 찾을 수 없습니다 >>> " + name);
        }
    }

    @Override
    public void deleteUser(String name) {
        int delete;
    delete = jdbcTemplate.update("DELETE FROM users WHERE name = ?", name);
    if (delete == 0) {
        throw new UserNotFoundException("해당 사용자의 데이터를 지울 수 없습니다 >>> "+name);
    }
    }
}
