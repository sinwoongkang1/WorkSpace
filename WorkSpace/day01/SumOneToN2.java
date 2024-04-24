package ch01;

import java.util.Scanner;

public class SumOneToN2 {
    public static int sumForN2 (int n) {
        int sum = 0 ;
        for (int i = 2; i <=n ; i+=2) {
            sum = sum + i ;
        }
        return sum ;
    }

    public static void main(String[] args) {
        System.out.println("1 부터 입력하신 값까지의 짝수 합을 구해드립니다 ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("입력하신 수 부터 1까지 짝수의 합은 : "+sumForN2(a));

    }
}
