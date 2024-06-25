package com.example.filterexam.filterexam2;
//ThreadLocal 을 이용해서 필요한 정보를 저장 하는데, 이 ThreadLocal 을 가지는 객체
//세션은 요청이 바뀌어도 유지되는 정보
//ThreadLocal 에 값을 저장하면  하나의 Tread 안에서만 유지되는 값. Thread 어디에서나 사용 가능
//UserContext 를 이용해서 USER_THREAD_LOCAL 을 생성, 수정, 가져오기, 삭제 할 수 있음.
public class UserContext {
    public static final ThreadLocal<User> USER_THREAD_LOCAL = ThreadLocal.withInitial(()->null);
    //하나의 user 를 Thread 흐름내 아무데서나 사용하도록 초기화 함.

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
