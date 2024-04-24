package day06.practice;

public class Bird extends Animal{
    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("짹쨱");
    }
}
