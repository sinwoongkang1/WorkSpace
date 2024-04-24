package ch02;

import java.util.Scanner;

public class ArrayMax {
    public static int maxOf(int[] scores) {
        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if(max > scores[i]) {
                return max;
            }else {
                max = scores[i];
            }
        }return max;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("점수의 최대값을 구합니다");
        System.out.println("학생의 수 : ");
        int num = stdIn.nextInt();
        int[] scores = new int [num];
        for (int i = 0; i < num; i++) {
            System.out.println("scores["+i+"]");
            scores[i] = stdIn.nextInt();
        }
        System.out.println("최대값은"+maxOf(scores));
    }
}
