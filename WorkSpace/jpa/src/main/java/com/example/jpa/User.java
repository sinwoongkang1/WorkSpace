package com.example.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="jpa_user") //클래스명과 테이블명이 같으면 생략가능, 다르게 할꺼면 @Table 로 명명
@Getter
@Setter
public class User {
    @Id //Id는 무조건 있어야 함.
    private Long id;
//    @Column
    private String name;
    private String email;

}
