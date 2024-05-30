package com.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    //이름으로 조회
//    @Query("select s From Customer s where s.name = :name")
//    List<Customer> findByName(@Param("name")String Name);
//    //이메일로 조회
//    @Query("select c from Customer c where c.email = :email")
//    List<Customer> findByEmail(@Param("email")String email);

     List<Customer> findByName(@Param("name")String name);
     List<Customer> findByEmail(@Param("email")String email);
     List<Customer> findByEmailContains(@Param("email")String email);

     //각 고객과 고객의 주문수를 알고 싶다.
     @Query("select c,count(o) from Customer c left join c.orders o group by c")
     List<Object[]> findCustomerOrderCount();
}
