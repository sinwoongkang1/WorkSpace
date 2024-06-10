package WorkSpace.WorkSpace.AlgorithmPractice.Programmers;

import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        int start = 10;
        int start_num = start;
        int end_num = 3;
        int[] answer = new int[(start-end_num) +1];

        for(int i=0; i <= start_num-end_num; i++){
            answer[i] = start;
            start--;
            System.out.println(start);
        }
        System.out.println(Arrays.toString(answer));
    }


    }
//    public static int[] solution(int start, int end_num) {
//        int[] answer = new int[end_num - start + 1];
//        int num = start;
//        System.out.println(start +" " + end_num);
//        for(int i = 0; (start-end_num)<=i; i++ ){
//            answer[i] = num;
//            num = num -1 ;
//            System.out.println(num);
//        }
//        return answer;
//    }
//}