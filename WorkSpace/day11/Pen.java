package day11;

public class Pen {
    String color;

    public Pen(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return color + "pen";
    }
}
