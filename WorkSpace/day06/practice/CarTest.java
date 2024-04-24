package day06.practice;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car("Hyundai","Sonata",2020);
        car.displayInfo();

        ElectricCar electricCar = new ElectricCar("Tesla","Model 5",2021,75);
        electricCar.displayInfo();
    }
}
