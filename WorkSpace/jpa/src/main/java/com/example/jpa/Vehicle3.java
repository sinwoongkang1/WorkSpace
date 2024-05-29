package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //상속 전략 선언
@Getter
@Setter
public class Vehicle3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String manufacture;

}
@Entity
@DiscriminatorValue("CAR")//실제로 구분할 값
@Getter
@Setter
class Car3 extends Vehicle3 {
    private int seatCount;
}

@Entity
@DiscriminatorValue("TRUCK")
@Getter
@Setter
class Truck3 extends Vehicle3 {
    private double payloadCapacity;
}