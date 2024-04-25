package day17;

import java.util.Arrays;
import java.util.List;

public class StreamExam4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

        List<Member> memberList = Arrays.asList(new Member("kang",100),new Member("kim",20)
        ,new Member("jung",40));

        int memberScoreSum = memberList.stream().mapToInt(Member::getScore).sum();
        System.out.println(memberScoreSum);

        int mem = memberList.stream().mapToInt(Member::getScore).reduce(1,(a,b)->a*b);
        System.out.println(mem);


    }
}
