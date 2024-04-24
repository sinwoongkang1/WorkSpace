package day16;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RamdaExam {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple","banana","cherry");
        items.forEach(a-> System.out.println(a));

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start");
            }
        }).start();

        new Thread(()-> System.out.println("start2") ).start();

        List<Integer> numbers = Arrays.asList(1,3,2,5,7);
        Collections.sort(numbers, (Integer a, Integer b)-> a.compareTo(b));
        numbers.forEach(e -> System.out.println(e));

    }
}
