package com.example.filterexam.filterexam4.filter;
import com.example.filterexam.filterexam4.entitiy.User;

public class UserContext {
    public static final ThreadLocal<User> USER_THREAD_LOCAL = ThreadLocal.withInitial(()->null);

    public static void setUser(User user) {
        USER_THREAD_LOCAL.set(user);
    }
    public static User getUser() {
        return USER_THREAD_LOCAL.get();
    }
    public static void clear(){
        USER_THREAD_LOCAL.remove();
    }
}
