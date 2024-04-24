package ch01;

import java.util.Scanner;

public class Median {
    public static int median(int a, int b, int c) {

        if (a > b) {
            if (b > c) {
                return b ;
            } else {
                if (a > c) {
                    return c ;
                } else {
                    return a;
                }
            }
        } else {
            if (a > c) {
                return a;
            } else {
                if (b > c) {
                    return c;
                } else {
                    return b;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("입력한 3가지 정수의 중앙값을 찾아드립니다.");
        int a = sc.nextInt();
        int b = sc1.nextInt();
        int c = sc2.nextInt();
        System.out.println("입력한 정수들의 중앙값 : "+median(a,b,c));
    }
}