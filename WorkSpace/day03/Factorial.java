package ch03;

import java.util.Scanner;

public class Factorial {
    static int factorial (int num) {
        if (num>0){
            return num * factorial(num-1);
        }else
            return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("팩토리얼을 구할 정수를 입력하세요");
        int a = scanner.nextInt();
        System.out.println("입력한 " +a+"!의 값은 "+factorial(a)+" 입니다.");
    }
}
