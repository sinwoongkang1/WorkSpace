package com.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * from jpa_user WHERE email LIKE %?1%", nativeQuery = true)
    List<User> findByEmailNative(String email);

    @Query(value = "SELECT count(*) from jpa_user where age > 30 and status = 'ACTIVE'", nativeQuery = true)
    int countOlderThan();
}
