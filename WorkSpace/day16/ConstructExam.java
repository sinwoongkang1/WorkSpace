package day16;

import java.util.function.BiFunction;
import java.util.function.Function;

class Car {
    String name;
    String speed;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, String speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return name + "+" +speed;
    }
}


public class ConstructExam {
    public static void main(String[] args) {
        Function<String,Car> function = name -> new Car(name);
        Car car = function.apply("K7-Hybrid");
        System.out.println(car.name);

        Function<String,Car> function1 = Car::new;
        Car car1 = function1.apply("K7");
        System.out.println(car1.name);

        BiFunction<String,String,Car> function2 = Car::new;
        Car car2 = function2.apply("K5","100");
        System.out.println(car2);

    }
}
