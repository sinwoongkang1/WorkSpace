package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleExamMain {
    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Car2 car1 = new Car2();
            car1.setManufacture("Toyoya");
            car1.setSeatCount(5);
            em.persist(car1);

            Car2 car2 = new Car2();
            car2.setManufacture("Hyundai");
            car2.setSeatCount(4);
            em.persist(car2);

            Truck2 truck1 = new Truck2();
            truck1.setManufacture("Volvo");
            truck1.setPayloadCapacity(15.5);
            em.persist(truck1);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            List<Vehicle2> vehicles = em.createQuery("SELECT v FROM Vehicle2 v", Vehicle2.class).getResultList();
            for (Vehicle2 vehicle : vehicles) {
                if (vehicle instanceof Car2) {
                    Car2 car = (Car2) vehicle;
                    log.info("Car: " + car.getManufacture() + ", Seats: " + car.getSeatCount());
                } else if (vehicle instanceof Truck2) {
                    Truck2 truck = (Truck2) vehicle;
                    log.info("Truck: " + truck.getManufacture() + ", Payload Capacity: " + truck.getPayloadCapacity());
                }
            }
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
//        create();
        find();
    }

}
