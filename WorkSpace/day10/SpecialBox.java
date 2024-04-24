package day10;

public class SpecialBox<T> extends Box<T> {

    public SpecialBox(T content) {
        super(content);
    }

    public void printContent() {
        System.out.println("special box contains " + getContent());
    }

    public static void main(String[] args) {
        SpecialBox<String> s = new SpecialBox<String>("phone");
        s.printContent();
    }
}
