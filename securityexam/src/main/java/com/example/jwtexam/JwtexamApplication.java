package com.example.jwtexam;

import com.example.jwtexam.jwt.util.JwtTokenizer;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class JwtexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtexamApplication.class, args);
    }

    @Autowired
    JwtTokenizer jwtTokenizer;

//    @Bean
    public CommandLineRunner run() {
        return args -> {
            String accessToken =  jwtTokenizer.createAccessToken(
                    1L,"test@test.com","test", "testuser", Arrays.asList("ROLE_USER")
            );

            log.info("AccessToken {}",accessToken);

            String refreshToken =  jwtTokenizer.refreshToken(
                    1L,"test@test.com","test", "testuser", Arrays.asList("ROLE_USER")
            );

            log.info("AccessToken {}",refreshToken);

            Long id = jwtTokenizer.getUserIdFromToken(accessToken);
            log.info("User id {}", id);

            Claims claims = jwtTokenizer.parseAccessToken(accessToken);
            log.info("Access Token Claims {}",claims);

            Claims refreshTokenClaims = jwtTokenizer.parseRefreshToken(refreshToken);
            log.info("Refresh Token Claims {}",refreshTokenClaims);

        };
    }
}
