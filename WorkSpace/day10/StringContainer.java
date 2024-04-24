package day10;

public class StringContainer implements Container<String> {
private String value;

    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }

    public static void main(String[] args) {
        StringContainer sc = new StringContainer();
        sc.set("hello Container");
        System.out.println(sc.get());
    }
}
