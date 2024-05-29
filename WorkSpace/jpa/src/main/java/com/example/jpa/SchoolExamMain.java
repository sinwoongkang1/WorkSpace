package com.example.jpa;

import jakarta.persistence.EntityManager;

public class SchoolExamMain {

    private static void studentFindById(int number){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Student student = em.find(Student.class,number);
            System.out.println("student name:::::"+ student.getName());
            System.out.println("school name:::::"+student.getSchool().getName());
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
    private static void studentFindBySchoolNumber(int number){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            School school = em.find(School.class,number);
            System.out.println("school Name::::: " + school.getName());
            for(Student student : school.getStudents()){
                System.out.println("student Name::::: " + student.getName());
                em.getTransaction().commit();
            }
        }
        finally {
            em.close();
        }
    }

    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    private static void updateStudentNameByNo(Long number ,String name){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Student student = em.find(Student.class,number);
            student.setName(name);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    private static void deleteSchoolByNo(Long number){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            School school = em.find(School.class,number);
            em.remove(school);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }


    public static void main(String[] args) {
//        studentFindById(5); // 5번 학생 정보 조회
//        studentFindBySchoolNumber(1); //1번 학교 정보 및 학생들 조회
        updateStudentNameByNo(3L,"kang");
//        deleteSchoolByNo(3);
    }
}
