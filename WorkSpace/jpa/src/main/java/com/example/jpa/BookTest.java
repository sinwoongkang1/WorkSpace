package com.example.jpa;

import jakarta.persistence.EntityManager;

public class BookTest {
    private static void findBookById(int number){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Books book = em.find(Books.class, number);
            em.getTransaction().commit();
            System.out.println(number+" 번의 책 정보:::"+book.getTitle()+" "+book.getAuthor().getName());

        }finally {
            em.close();
        }
    }
    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Authors author = new Authors("kang");
            Books book = new Books("javajava",author);

            author.getBooks().add(book);
            em.persist(author);
            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }






    public static void main(String[] args) {
//    findBookById(6);
    create();
    }

}
