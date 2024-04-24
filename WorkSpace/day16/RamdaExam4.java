package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class RamdaExam4 {
    public static void main(String[] args) {
        //메서드 참조
        BiFunction<Integer,Integer,Integer> maxFunc = Math::max;
//        BiFunction<Integer,Integer,Integer> maxFunc = (a,b) -> Math.max(a,b);
        System.out.println(maxFunc.apply(10,4));

        //인스턴스 메서드 참조
        String str = "Hello world";
        Supplier<Integer> lengthFunc = str::length;
        System.out.println(lengthFunc.get());

        //임의 객체의 인스턴스 메서드 참조
        List<String> words = Arrays.asList("Hello","world","java","kang");
        List<Integer> lengths = new ArrayList<>();
        Function<String,Integer> lengthFunc2 = String::length;
        for(String word : words) {
            lengths.add(lengthFunc2.apply(word));
        }
        System.out.println(lengths);

        //생성자 참조
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> list  = listSupplier.get();
        //리스트가 생성된다.
    }
}
