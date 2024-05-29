package com.example.jpa;

public class UserMain {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.findUser(1L);

    }
}
