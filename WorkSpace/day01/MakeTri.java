package ch01;

import java.util.Scanner;

public class MakeTri {

    public static void maketri (int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력하신 값 높이의 이등변 삼각형을 출력합니다");
        int a = sc.nextInt();

     maketri(a);

    }
}
