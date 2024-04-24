package day11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueCharacters {
    public static void main(String[] args) {
        String input = "banana";
//        Set<Character> chars = new LinkedHashSet<>(); //순서를 유지
        Set<Character> chars = new HashSet<>(); //순서 상관 없이

        for (char ch : input.toCharArray()) {
            chars.add(ch);
        }

        // 중복 제거된 문자 출력
        System.out.print("Unique characters: ");
        for (char ch : chars) {
            System.out.print(ch);
        }
    }
}
