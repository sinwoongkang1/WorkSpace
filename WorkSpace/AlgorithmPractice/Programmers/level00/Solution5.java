package WorkSpace.WorkSpace.AlgorithmPractice.Programmers.level00;

import java.util.Arrays;

public class Solution5 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,10)));
    }
    public static int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num-start_num+1];
        for (int i = 0; i < answer.length; i++) {
            answer[i]=start_num;
            start_num++;
        }
        return answer;
    }
}
