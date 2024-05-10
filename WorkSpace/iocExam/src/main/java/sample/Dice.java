package sample;

import org.springframework.stereotype.Component;

@Component
public class Dice {
    private int face;
    public Dice() {
        System.out.println("Dice() 실행");
    }
    public Dice(int face) {
        this.face = face;
        System.out.println("Dice(int) 실행");
    }
    public int getNumber() {
        return  (int)( (Math.random() * face) +1);
    }
}
