package day17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExam5 {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("kang",Member.MALE,30),
                new Member("jung",Member.FEMALE,28),
                new Member("kim",Member.FEMALE,26),
                new Member("son",Member.MALE,24)
        );

        Map<Integer,List<Member>> newMemberList = memberList.stream()
                .collect(Collectors.groupingBy(Member::getSex));
        newMemberList.get(Member.MALE).stream().forEach(a -> System.out.println(a.getName()));

    }
}
