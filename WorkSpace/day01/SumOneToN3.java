package ch01;

import java.util.Scanner;

public class SumOneToN3 {
        public static int sumForN3 (int n) {
            int sum = 0 ;
            for (int i = 3; i <=n ; i+=3) {
                sum = sum + i ;
            }
            return sum ;
        }

        public static void main(String[] args) {
            System.out.println("1 부터 입력하신 값까지의 3의 배수 합을 구해드립니다 ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            System.out.println("입력하신 수 부터 1까지 3의 배수의 합은 : "+sumForN3(a));

        }
    }
