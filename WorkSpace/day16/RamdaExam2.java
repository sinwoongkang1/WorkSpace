package day16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class RamdaExam2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","David","Echo","Bob","Charlie");
        //기존 방식으로 문자 알파벳 순으로 정렬
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(names);

        //람다 방식으로 문자 역순 정렬
        names.sort(((o1, o2) -> o2.compareTo(o1)));
        System.out.println(names);

        Consumer<String> printName = name -> System.out.println(name);
        names.forEach(printName);


    }
}
