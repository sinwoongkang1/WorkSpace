package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //상속 전략 선언 join table
@Getter
@Setter
public class Vehicle2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String manufacture;

}
@Entity
@DiscriminatorValue("CAR")//실제로 구분할 값
@Getter
@Setter
class Car2 extends Vehicle2 {
    private int seatCount;
}

@Entity
@DiscriminatorValue("TRUCK")
@Getter
@Setter
class Truck2 extends Vehicle2 {
    private double payloadCapacity;
}