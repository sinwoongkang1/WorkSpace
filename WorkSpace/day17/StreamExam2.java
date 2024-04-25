package day17;

import java.util.Arrays;
import java.util.List;

public class StreamExam2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream()
                .forEach(n->System.out.println("Number : "+n));

        List<Integer> doubleNumber = numbers.stream()
                .peek(n-> System.out.println("Processing 1 :"+n))
                .map(n->n*2)
                .peek(n-> System.out.println("Processing 2 :"+n)).toList();
        System.out.println(doubleNumber);
        System.out.println("==================");

        boolean allPositive = numbers.stream().allMatch(n->n>0);
        boolean anyNegative = numbers.stream().anyMatch(n->n<0);
        boolean nonAboveTen = numbers.stream().noneMatch(n->n>10);
        System.out.println(allPositive);
        System.out.println(anyNegative);
        System.out.println(nonAboveTen);

        System.out.println("====================");
        int[] intArr = {2, 4, 6, 8};

        boolean result = Arrays.stream(intArr).allMatch(n->n%3==0);
        System.out.println("모두 3의 배수 입니까??" + result);

        boolean result2 = Arrays.stream(intArr).anyMatch(n->n%3==0);
        System.out.println("하나라도 3의 배수 입니까??" + result2);

        boolean result3 = Arrays.stream(intArr).noneMatch(n->n%3==0);
        System.out.println("모두 3의 배수가 아닙니까??" + result3);
    }
}
