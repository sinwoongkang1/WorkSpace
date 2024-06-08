package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Scanner;

public class Stringpro {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("0","0"));
    }
}


class Solution {
    public String solution(String a, String b) {
        String answer = "";
        Long aa = Long.parseLong(a);
        Long bb = Long.parseLong(b);
        Long dd = aa+bb;
        String cc = Long.toString(dd);
        answer = cc;
        return answer;
    }
}