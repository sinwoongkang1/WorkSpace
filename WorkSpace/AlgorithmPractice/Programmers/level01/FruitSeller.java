package WorkSpace.WorkSpace.AlgorithmPractice.Programmers.level01;

import java.util.Arrays;

public class FruitSeller {
    public static void main(String[] args) {
    int[] arr = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(solution(4,3,arr));
    }
    public static int solution(int k, int m, int[] score) {
        int replace;
        for(int i = 0; i < score.length; i++){
            for(int j = 0; j < score.length-1; j++){
                if(score[j] > score[j+1]){
                    replace = score[j];
                    score[j] = score[j+1];
                    score[j+1] = replace;
                }
            }
        }
        int answer = 0;
        int boxEa = score.length / m;
        int sum = 0;
        for(int i = 1; i <= boxEa; i++){
           sum = sum + m * score[(score.length-m*(i))];
        }
        answer = sum;
return answer;
    }
}
