package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속 전략 선언 싱글 테이블
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)//구분할 컬럼의 타입을 정해줌
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String manufacture;

}
@Entity
@DiscriminatorValue("CAR")//실제로 구분할 값
    @Getter
@Setter
class Car extends Vehicle {
    private int seatCount;
}

@Entity
@DiscriminatorValue("TRUCK")
@Getter
@Setter
class Truck extends Vehicle {
    private double payloadCapacity;
}