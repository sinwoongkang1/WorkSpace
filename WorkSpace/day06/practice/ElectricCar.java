package day06.practice;

public class ElectricCar extends Car{

    int batteryCapacity ;

    public ElectricCar(String brand, String model, int year, int batteryCapacity) {
        super(brand, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(this.batteryCapacity);

    }
}
