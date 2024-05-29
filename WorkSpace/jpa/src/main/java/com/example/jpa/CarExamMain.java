package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class CarExamMain {
    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Car car1 = new Car();
            car1.setManufacture("Toyoya");
            car1.setSeatCount(5);
            em.persist(car1);

            Car car2 = new Car();
            car2.setManufacture("Hyundai");
            car2.setSeatCount(4);
            em.persist(car2);

            Truck truck1 = new Truck();
            truck1.setManufacture("Volvo");
            truck1.setPayloadCapacity(15.5);
            em.persist(truck1);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    private static void createQuery() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            List<Vehicle> vehicles = em.createQuery("SELECT v FROM Vehicle v", Vehicle.class).getResultList();
            for (Vehicle vehicle : vehicles) {
                if(vehicle instanceof Car){
                    Car car = (Car) vehicle;
                    log.info("Car info :::::{},{}",car.getManufacture(),car.getSeatCount());
                } else if (vehicle instanceof  Truck) {
                    Truck truck = (Truck) vehicle;
                    log.info("Truck info:::::{},{}",truck.getManufacture(),truck.getPayloadCapacity());
                }
            }

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public static void main(String[] args) {
//        create();
       createQuery();
    }

}
