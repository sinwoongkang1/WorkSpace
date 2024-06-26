package com.example.securityexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http           //인가에 대한 설정
                        .authorizeRequests(authorizeRequest -> authorizeRequest
                        .anyRequest() //모든요청
                        .authenticated()//모든인증
                        );


        http
                        .formLogin(formLogin -> formLogin
    //                        .loginPage("/loginForm") //로그인 폼을 내가 쓰고 싶은 url 로
                            .defaultSuccessUrl("/success") //로그인 성공시 보여질 페이지
                            .successHandler((request, response, authentication) -> {
                                log.info("Login successful^^");
                                response.sendRedirect("/success"); //핸들러가 우선순위, 디폴트 무시됨
                            })//로그인을 성공하면 할 일 정할 수 있다.
                            .failureUrl("/fail") //로그인 실패시 보여질 페이지
                            .usernameParameter("userId") // name 값이 username -> userId 로 변경됨
                            .passwordParameter("passwd")
                            .loginProcessingUrl("/login_p")
                            .permitAll()); //로그인 페이지에 대한 요청은 누구나 할 수 있도록

        http            .logout(logout -> logout
                            .logoutUrl("/log_out")
                            .logoutSuccessUrl("/login")
                            .logoutSuccessHandler((request, response, authentication) ->
                                    log.info("Logout successful")
                            )
                           .deleteCookies("JSESSIONID")
                            );

        return http.build();

    }
}
