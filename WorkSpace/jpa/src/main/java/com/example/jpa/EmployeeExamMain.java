package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeExamMain {
    private static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Project project = em.find(Project.class,1L);
            log.info("프로젝트 이름:::::"+project.getName());

            for(Employee employee:project.getEmployees()){
                log.info("사원이름:::::"+employee.getName());
            }

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = new Employee();
            employee.setName("kang");
            Project project = new Project();
            project.setName("Lion Project");

            employee.getProjects().add(project);
            project.getEmployees().add(employee);
            em.persist(employee);
            em.persist(project);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = em.find(Employee.class,3L);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Employee employee = em.find(Employee.class,3L);
            employee.setName("jung");
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }




    public static void main(String[] args) {
//        find();
//        create();
//        update();
        delete();
    }
}
