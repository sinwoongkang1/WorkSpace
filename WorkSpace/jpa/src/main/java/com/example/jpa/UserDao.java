package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDao {

    private EntityManagerFactory emf;

    public UserDao(){
        emf = Persistence.createEntityManagerFactory("UserPU");
    }
    public void close(){
        if(emf != null){
            emf.close();
        }
    }

    public void createUser(User user){
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();

        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }
    
}
