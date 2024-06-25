package com.example.filterexam.filterexam2;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//bean 을 등록하는 설정파일 (필터를 빈으로 등록할거임)
@Configuration
public class FilterConfig {
    @Bean //필터를 등록할 때 @ 방법보다 config 를 이용하면 좀 더 직관적이고 디테일한 설정이 가능
    public FilterRegistrationBean<UserFilter> authenticationFilter() {
        FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean<>();
        UserFilter userFilter = new UserFilter();
        registrationBean.setFilter(userFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1); //필터 실행 시 우선순위 설정.
        return registrationBean;
    }
}
