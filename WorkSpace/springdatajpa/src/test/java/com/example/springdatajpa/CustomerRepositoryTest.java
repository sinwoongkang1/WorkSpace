package com.example.springdatajpa;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

class CustomerRepositoryTest {
private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void save(){
    Customer customer = new Customer("kang","kang@email.com");
    customerRepository.save(customer);
    assertThat(customerRepository.findById(11L).orElseThrow().getName()).isEqualTo(customer.getName());

}
    @Test
    void delete(){
    Customer customer = new Customer("kang","kang@email.com");
    customerRepository.delete(customer);
    assertThat(customerRepository.findById(12L).isPresent());

}
    @Test
    void findCustomerOrderCount(){
         List<Object[]> objectList= customerRepository.findCustomerOrderCount();
         objectList.forEach(object->{
             Customer customer = (Customer) object[0];
             Long orderCount = (Long) object[1];
         });
    }
    @Test
    void findCustomerWithLastOrder(){
        List<Object[]> objectList= customerRepository.findCustomerWithLastOrder();
        objectList.forEach(object->{
            Customer customer = (Customer) object[0];
            Order order = (Order) object[1];
            System.out.println(customer.getName()+"-"+customer.getEmail()+":::"+ order.getProduct());
        });
    }

    @Test
    @SqlGroup({
            @Sql(value = "classpath:db/test.sql",
                    config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
                    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    })
    void findCustomerOrderThanAverage(){
        List<Customer> customersOlderThanAverage = customerRepository.findCustomerOrderThanAverage();
        customersOlderThanAverage.forEach(result -> {
            Customer customer = result;
            System.out.println(customer.getName()+":::"+customer.getAge());
            assertThat(customersOlderThanAverage).hasSize(8);
        });
    }



}

