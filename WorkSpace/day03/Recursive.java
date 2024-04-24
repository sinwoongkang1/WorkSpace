package ch03;

public class Recursive {
    static void recursive(int n) {
        if (n > 0) {
            recursive(n-1);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        recursive(5);
    }
}
