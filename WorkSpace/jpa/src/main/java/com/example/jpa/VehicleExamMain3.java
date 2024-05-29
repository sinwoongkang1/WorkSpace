package com.example.jpa;

import jakarta.persistence.EntityManager;

public class VehicleExamMain3 {
    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
// 데이터 삽입
        em.getTransaction().begin();

        Car3 car1 = new Car3();
        car1.setManufacture("Toyota");
        car1.setSeatCount(5);
        em.persist(car1);

        Car3 car2 = new Car3();
        car2.setManufacture("Honda");
        car2.setSeatCount(4);
        em.persist(car2);

        Truck3 truck1 = new Truck3();
        truck1.setManufacture("Volvo");
        truck1.setPayloadCapacity(15.5);
        em.persist(truck1);

        Truck3 truck2 = new Truck3();
        truck2.setManufacture("Scania");
        truck2.setPayloadCapacity(20.0);
        em.persist(truck2);

        em.getTransaction().commit();
        em.close();
    }
    private static void find(){}
    public static void main(String[] args) {
        create();

    }
}
