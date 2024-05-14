package org.example.springdatajdbc01;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomUserRepository {
    Page<User> findAllWithPagination(Pageable pageable); //커스텀 쿼리문 작성하기
}
