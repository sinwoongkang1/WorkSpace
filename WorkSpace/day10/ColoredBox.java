package day10;

public class ColoredBox<T,C> extends Box<T> {
    private C color;

    public ColoredBox(T content,C color) {
        super(content);
        this.color = color;
    }
    public C getColor() {
        return color;
    }
    public String toString() {
        return "ColoredBox with Color : "+color + " containing : " +getContent();
    }

    public static void main(String[] args) {
        ColoredBox coloredBox = new ColoredBox("pen","red");
        System.out.println(coloredBox);

    }
}
