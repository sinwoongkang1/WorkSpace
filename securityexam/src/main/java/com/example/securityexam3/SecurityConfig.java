package com.example.securityexam3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                        .authorizeRequests(authorizeRequest -> authorizeRequest
                        .requestMatchers("/shop/**","/test").permitAll()
                        .requestMatchers("/user").hasRole("USER")
                        .requestMatchers("both").hasAnyRole("USER", "ADMIN")
                        .anyRequest() //모든 요청
                        .authenticated() //인증을 요구
                        )
                        .formLogin(Customizer.withDefaults());
        return http.build();
    }
    //비밀번호를 인코딩하는 로직
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //인가받은 사용자를 등록하는 빈
    @Bean
    public UserDetailsService userDetailsService() {
        //실제 프로젝트에선 이 부분을 DB에 있는 사용자 정보를 이용하도록 작성해야 함.
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                .roles("USER") //ROLE_ 이 디폴트로 붙는다.
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN") //ROLE_ 이 디폴트로 붙는다.
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
