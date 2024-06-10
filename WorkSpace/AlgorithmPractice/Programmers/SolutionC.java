package WorkSpace.WorkSpace.AlgorithmPractice.Programmers;

import java.util.Arrays;

public class SolutionC {
    public int[] solution(int start, int end_num) {
        int[] answer = {};
        for(int i = 0; (start-end_num)<=i; i++ ){
            answer[i] = --start;
        }
        return answer;
    }

    public static void main(String[] args) {
        SolutionC solution = new SolutionC();
        System.out.println(Arrays.toString(solution.solution(10,3)));
    }
}
