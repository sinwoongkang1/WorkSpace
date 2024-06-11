package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Scanner;

public class Problem2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= (number*2)-(i*2) ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <=i ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= number-i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <=(i*2) ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <=number-i ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
