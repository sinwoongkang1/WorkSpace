package ch01;

import java.util.Scanner;

public class MakeTri2 {

    public static void maketri2 (int n) {
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <=i ; j++) {
                System.out.print("*");
            }System.out.println();
        }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("입력하신 높이의 이등변 삼각형을 만들어드립니다");
       int a = sc.nextInt();
       maketri2(a);
    }
        }


