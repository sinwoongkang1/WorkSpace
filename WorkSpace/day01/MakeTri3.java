package ch01;

import java.util.Scanner;

public class MakeTri3 {

    public static void maketri3 (int n) {
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j < i+i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입력하신 높이의 이등변 삼각형을 만들어드립니다");
        int a = sc.nextInt();
        maketri3(a);
    }

}
