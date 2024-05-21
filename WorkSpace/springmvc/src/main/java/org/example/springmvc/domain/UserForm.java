package org.example.springmvc.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    @NotEmpty(message = "공백은 허용되지 않습니다") //해당 필드들이 공백이면 안된다 (메시지로 사용자에게 알려줄 수 있다.)
    @Size(min = 4,max = 20, message = "ID 는 4자~20자 만 사용가능")
    private String username;
    @NotEmpty(message = "공백은 허용되지 않습니다")
    @Size(min = 6, message = "PW 는 6자 이상으로 설정해주세요.")
    private String password;
}
