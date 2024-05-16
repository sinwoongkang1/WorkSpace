package org.example.springdatajdbc01;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//엔티티클래스 (DTO는 단순히 값만 담아서 전달하는 객체, 엔티티는 DB와의 관계를 알려준다)
@Table("users") //테이블명고 클래스명이 같으면 생략, 다르면 명시하여 매핑 가능
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id //pirmaryKey에 ID 를 붙여줘야 함
    private Long id;
    private String name;
    private String email;
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
