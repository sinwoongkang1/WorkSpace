package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonExamMain {
    private static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Person person = em.find(Person.class, 1);
            log.info(person.getName());
            log.info(person.getPassport().getPassportNumber());

            Passport passport = em.find(Passport.class, 1);
            log.info(passport.getPassportNumber());
            log.info(passport.getPerson().getName());

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Person person = new Person();
            person.setName("Kang");
            Passport passport = new Passport();
            passport.setPassportNumber("P23ASD34");
            passport.setPerson(person);
            person.setPassport(passport);

            em.persist(person);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Person person = em.find(Person.class,4L);
            em.remove(person);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Person person = em.find(Person.class,4);
            person.setName("Jung");
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        create();
        find();
        update();
       delete();

    }
}
