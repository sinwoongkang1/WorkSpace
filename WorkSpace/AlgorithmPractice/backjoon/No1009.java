package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Scanner;

public class No1009 {
    public static long findComputer(long a,long b){
        b=b%4;
        if (a ==10){
            return 10;
        }
        else {
            int data = (int) Math.pow(a, b);
            data = data % 10;
            return data;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        System.out.println(findComputer(a,b));
    }
}
