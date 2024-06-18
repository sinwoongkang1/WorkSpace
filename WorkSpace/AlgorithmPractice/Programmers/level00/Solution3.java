package WorkSpace.WorkSpace.AlgorithmPractice.Programmers.level00;

public class Solution3 {
    public static void main(String[] args) {
        int a = solution(2,91);
        System.out.println(a);
        int b = solution(91,2);
        System.out.println(b);
    }
        public static int solution(int a, int b) {
            int answer = 0;
            int sum1 = 2*a*b;

            String num1 = Integer.toString(a);
            String num2 = Integer.toString(b);
            String result = num1 + num2;
            Integer sum2 = Integer.parseInt(result);

            if(sum1 > sum2){
                answer = sum1;
            }else {
                answer = sum2;
            }
            return answer;
        }

}
