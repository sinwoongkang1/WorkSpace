package day06.practice;

public class Car {
    String brand;
    String model;
    int year ;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void displayInfo(){
        System.out.println(this.brand);
        System.out.println(this.model);
        System.out.println(this.year);
    }
}
