package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {//factory 를 만들고나서 manager 를 생성한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = emf.createEntityManager();

        //엔티티 생성 --> 아직은 영속성 컨텍스트가 관리하지 않는 상태!! (비영속상태)
        User user = new User();
        user.setId(1L);
        user.setName("kang");
        user.setEmail("email@email.com");
        //여기 까지도 영속성 컨텍스트가 관리하지 않음.

        entityManager.getTransaction().begin();
        //영속성 컨텍스트에게 관리를 맏김. (영속 상태)
        entityManager.persist(user); //실행해도 Transaction 때문에 동작은 안함.

        //이때 DB에 저장 (영속성이 엔티티를 파악하고 DB와 비교해서 Insert 한다)
        entityManager.getTransaction().commit();
    }
}
