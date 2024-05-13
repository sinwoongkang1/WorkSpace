package org.example.iocexam.service;

import org.example.iocexam.dao.UserDao;
import org.example.iocexam.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //dao 객체가 있어야 정보를 가지고 회원가입을 한다
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(@Qualifier("user2DaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    // UserDao를 주입받기위해서 셋터를 만들자
    @Override
    public void joinUser(User user) {
        //회원가입을 위한 비지니스 코드가 작성되어야 함,
        //회원가입을 위한 비지니스가 수행되면, 해당 데이터를 저장하는 코드가 실행
        userDao.addUser(user);
    }
}
