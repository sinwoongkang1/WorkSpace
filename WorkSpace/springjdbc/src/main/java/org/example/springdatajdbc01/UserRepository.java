package org.example.springdatajdbc01;

import org.springframework.data.repository.CrudRepository;
//crudRepository를 상속받는다
public interface UserRepository extends CrudRepository<User, Long> , CustomUserRepository{ //인티티클래스, ID로 설정한거 두개를 매개변수로
User findByName(String name); //쿼리를 알려주지 않기 때문에 함수이름으로 기능을 유추 -> 함수 명명 규칙을 따라야 한다.
} //필요한 메서드 선언해서 사용가능 (규칙 존재)
