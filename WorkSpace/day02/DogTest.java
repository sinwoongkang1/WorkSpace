package ch02;

public class DogTest {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.breed = "Bichon";
        myDog.age = 3;
        myDog.color = "White";
        myDog.bark();
        myDog.displayInfo();
    }
}
