package day17;

import java.util.Arrays;
import java.util.List;

public class StreamExam3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        long count = numbers.stream().count();
        int max = numbers.stream().max(Integer::compareTo).orElse(0);
        int min = numbers.stream().min(Integer::compareTo).orElse(0);
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(count);
        System.out.println(max);
        System.out.println(min);
        System.out.println(average);
        System.out.println(sum);
    }
}
