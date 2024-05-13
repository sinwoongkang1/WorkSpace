package org.example.iocexam.dao;

import org.example.iocexam.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class User2DaoImpl implements UserDao {
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user+ " 의 정보를 NewDao를 통해 잘 저장되었습니다.");
    }
}
