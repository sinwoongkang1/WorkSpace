package day01;

import java.util.Scanner;

public class Exam {
    public static int maxScore (int[] arrays) {
        int maxValue = arrays[0];
        for (int i = 0; i < arrays.length; i++) {
            if(maxValue > arrays[i]) {
                return maxValue ;
            } else {
                maxValue = arrays[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("학생 수를 입력하세요");
        int number = sc.nextInt();
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("학생 "+(i+1)+" 의 점수를 입력하세요");
            int putScore = sc.nextInt();
            array[i]=putScore;
        }
        System.out.println("입력한 점수들의 최대값은 : "+ maxScore(array)+"입니다.");

    }
}
