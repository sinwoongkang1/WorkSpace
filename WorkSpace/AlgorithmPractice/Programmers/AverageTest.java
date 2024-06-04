package WorkSpace.WorkSpace.AlgorithmPractice.Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class AverageTest {
    public static int findMaxScore(int[] array){
        Arrays.sort(array);
        int maxScore = array[array.length-1];
        System.out.println("입력한 값 중 최고 점수 = " + maxScore);
        return maxScore;
    }
    public static void makeAverageArray(int[] array,double a){
        double[] array2 = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            if(array[i]<=a){
            array2[i]=(array[i]/a)*100;}
        }
        System.out.println("점수들을 최고점수로 나눠서 재배열"+Arrays.toString(array2));
        double sum = 0;
        for (int i = 0; i < array2.length; i++) {
            sum = sum + array2[i];
        }
        double result = sum / array2.length;
        System.out.println("사기친 점수의 합계 : "+sum);
        System.out.println("평균 : "+result);
    }
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
        System.out.println("과목 수를 입력하세오.");
        int n = scanner.nextInt();
        int[] firstExamScores = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) +" 번째 과목 점수 입력");
            int m = scanner1.nextInt();
            firstExamScores[i]=m;
        }
        System.out.println("입력한 점수들의 값을 배열로 만듬"+Arrays.toString(firstExamScores));
        double score1 = findMaxScore(firstExamScores);
        makeAverageArray(firstExamScores,score1);
    }
}
