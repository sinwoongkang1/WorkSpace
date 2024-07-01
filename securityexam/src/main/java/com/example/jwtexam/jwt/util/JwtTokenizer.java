package com.example.jwtexam.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtTokenizer {
    private final byte[] accessSecret;
    private final byte[] refreshSecret;

    public static long ACCESS_TOKEN_EXPIRATION_COUNT = 30 *60 * 1000L; //30분

    public static long REFRESH_TOKEN_EXPIRATION_COUNT =  7 * 24 * 60 * 60 * 1000L; // 7일

    public JwtTokenizer(@Value("${jwt.secretKey}")String secretSecret,@Value("${jwt.refreshKey}")String refreshSecret) {
        this.accessSecret = secretSecret.getBytes(StandardCharsets.UTF_8);
        this.refreshSecret = refreshSecret.getBytes(StandardCharsets.UTF_8);
    }

    private String createToken(long id,String email,String name, String username, List<String> roles, long expire, byte[] secretKey) {

        Claims claims = Jwts.claims().setSubject(email); //email 말고 아무거나 입력가능

        claims.put("name", name);
        claims.put("username", username);
        claims.put("roles", roles);
        claims.put("userId", id);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expire))
                .signWith(getSigningKey(secretKey))
                .compact();
    }
    public static Key getSigningKey(byte[] secretKey) {
        return Keys.hmacShaKeyFor(secretKey);
    }

    //ACCESS Token 생성
    public String createAccessToken(Long id, String email, String name, String username, List<String> roles) {
        return createToken(id,email,name,username,roles,ACCESS_TOKEN_EXPIRATION_COUNT,accessSecret);
    }
    //REFRESH Token 생성
    public String refreshToken(Long id, String email, String name, String username, List<String> roles) {
        return createToken(id,email,name,username,roles,REFRESH_TOKEN_EXPIRATION_COUNT,refreshSecret);
    }
    public Long getUserIdFromToken(String token){
        String[] tokenArr = token.split(" ");
        token = tokenArr[1];
        Claims claims = parseToken(token,accessSecret);
        return Long.valueOf((Integer)claims.get("userId"));
    }

    public Claims parseToken(String token, byte[] secretKey){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public Claims parseAccessToken(String accessToken) {
        return parseToken(accessToken, accessSecret);
    }

    public Claims parseRefreshToken(String refreshToken) {
        return parseToken(refreshToken, refreshSecret);
    }
}
