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

     //각 고객과 고객의 주문 수
     @Query("select c,count(o) from Customer c left join c.order o group by c")
     List<Object[]> findCustomerOrderCount();

     //고객의 세부정보와 그들의 최근 주문 조회
     @Query("select c,o from Customer c join c.order o where o.date = (select max(o2.date) from Order o2 where o2.customer = c)")
     List<Object[]> findCustomerWithLastOrder();

     //고객의 평균 나이보다 많은 고객 조회
     @Query("select c from Customer c where c.age > (select AVG(c2.age) from Customer c2)")
     List<Customer> findCustomerOrderThanAverage();
}
