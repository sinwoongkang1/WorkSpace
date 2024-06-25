package com.example.filterexam.filterexam2;

import jakarta.servlet.*;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //사용자가 요청하면서 보낸 값이 있다면 추출해서 UserContext 에 저장하도록 세팅.
        User user = new User();
        user.setUsername("kang");
        user.setUsername("kang1234");

        //static 메서드임으로 바로 호출해서 사용 가능.
        //UserContext 에 값을 저장했음. 이 값을 어느 시점에서 어떻게 사용 가능한지 확인해보자.
        UserContext.setUser(user);

        filterChain.doFilter(servletRequest, servletResponse);

        UserContext.clear();
        //쓰레드풀을 사용하므로, 기존에 사용한 쓰레드가 남아 있으면 안되니까 반드시 한 번 쓰면 종료해주는게 필요.
        //반드시 실행 - > try -catch-finally 로 감싸주는게 좋다.
    }
}
