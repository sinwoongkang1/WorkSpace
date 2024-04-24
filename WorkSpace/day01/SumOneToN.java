package ch01;

import java.util.Scanner;

public class SumOneToN {
    public static int sumForN (int n) {
        int sum = 0 ;
        for (int i = 1; i <=n ; i+=2) {
            sum = sum + i ;
        }
        return sum ;
    }

    public static void main(String[] args) {
        System.out.println("양수의 값을 입력받아 홀수의 합을 구해드립니다 ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a>0) {
            System.out.println("입력하신 수 부터 홀수의 합은 : "+sumForN(a));
        }else {
            System.out.println("양수를 입력해주세요");
        }


    }
}
