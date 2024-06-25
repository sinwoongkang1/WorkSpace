package com.example.filterexam.filterexam1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
//필터는 어떤 요청을 처리하기 전, 후에 해야할 일들을 처리하는 것.
//필더 자체를 요청할 순 없다.
//요청이 들어온다 -> 로그인 한 사용자인지 필터링 하는 것.
@Slf4j
@Component  //나도 빈으로 등록해줘!! -> 사버 시작 시 빈으로 등록된다, 서버 시작시 필터가 생성된다. 일을 할 수 있다.
@WebFilter(urlPatterns = "/hi")
public class FristFilter implements Filter {
    public FristFilter() {
        log.info("FristFilter 생성자 실행!!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("FristFilter init 메서드 실행!!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("FristFilter doFilter 메서드 실행 전!!");
    filterChain.doFilter(servletRequest, servletResponse);
        log.info("FristFilter doFilter 메서드 실행 후!!");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("FristFilter destroy 메서드 실행 !!");
    }
}
