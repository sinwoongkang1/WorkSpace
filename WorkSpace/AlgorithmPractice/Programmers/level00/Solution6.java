package WorkSpace.WorkSpace.AlgorithmPractice.Programmers.level00;

public class Solution6 {
    public static void main(String[] args) {
        System.out.println(solution(9,91));
        System.out.println(solution(89,8));
    }
    public static int solution(int a, int b) {
        int answer = 0;
        String letter1 = Integer.toString(a);
        String letter2 = Integer.toString(b);
        String letter3 = letter1 + letter2;
        String letter4 = letter2 + letter1;
        int answer1 = Integer.parseInt(letter3);
        int answer2 = Integer.parseInt(letter4);
        if (answer1 > answer2) {
            answer = answer1;
        }else if (answer2 > answer1) {
            answer = answer2;
        }else if (answer1 == answer2) {
            answer = answer1;
        }
        return answer;
    }
}
