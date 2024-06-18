package WorkSpace.WorkSpace.AlgorithmPractice.Programmers.level00;

public class Solution4 {
    public static void main(String[] args) {
        int[] array = {5,7,3,8};
        System.out.println(solution(array));
    }

    public static int solution(int[] num_list) {
        int answer = 0;
        int sum =0;
        int multiSum = 1 ;
        for (int i = 0; i < num_list.length; i++) {
            sum += num_list[i];
        }
        for (int i = 0; i < num_list.length; i++) {
            multiSum *= num_list[i];
        }
        int sumSquare = sum * sum;
        if (sumSquare > multiSum) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}