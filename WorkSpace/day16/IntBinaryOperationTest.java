package day16;

import java.util.function.Consumer;

public class IntBinaryOperationTest {
    public static void main(String[] args) {
        IntBinaryOperation test = new IntBinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return 0;
            }
        };
        test = (a,b) -> { return a+b ;};
        System.out.println(test.apply(4,5));

        IntBinaryOperation minus = new IntBinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return 0;
            }
        };
        minus = ((a, b) -> a-b);
        int m = minus.apply(10,5);
        System.out.println(m);

        IntBinaryOperation bSum = ((a, b) -> a+b+a+b);
        System.out.println(bSum.apply(10,3));

        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("hello");

    }
}
