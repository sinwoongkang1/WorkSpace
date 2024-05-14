package org.example.jdbc01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor //모든 필드를 매개변수로 갖는 생성자가 추가된다
@Getter //모든 필드의 Getter 가 생성된다.
@ToString //toString 메서드를 오버라이딩 한다.
public class User {
    private Long id;
    private String name;
    private String email;


}
