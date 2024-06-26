package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Scanner;

public class No1075 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int F = sc.nextInt();

        int length = String.valueOf(N).length();
        String number = String.valueOf(N);
        String modifiedNumber = number.substring(0, length - 2) + "00";
        int myNumber = Integer.parseInt(modifiedNumber);

    for (int i = 0; i < 100 ; i++) {
        if (myNumber % F ==0){
            break;
        }else {
            myNumber++;
        }
    }
    String result = String.valueOf(myNumber);
        System.out.print(result.charAt(length - 2));
        System.out.print(result.charAt(length - 1));

    }
}
