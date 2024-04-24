package WorkSpace.WorkSpace.AlgorithmPractice;

import java.util.Arrays;
import java.util.Scanner;

public class BeakJoon2 {

    static int yootSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum = sum + array[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            System.out.println("0 또는  1을 입력하세요");
            int y = scanner.nextInt();
            array[i] = y ;
        }

        if (yootSum(array)==0){
            System.out.println(Arrays.toString(array)+" : 윷");
        } else if (yootSum(array)==1) {
            System.out.println(Arrays.toString(array)+" : 도");
        } else if(yootSum(array)==2) {
            System.out.println(Arrays.toString(array)+" : 개");
        } else if (yootSum(array)==3) {
            System.out.println(Arrays.toString(array)+" : 걸");
        } else
            System.out.println(Arrays.toString(array)+" : 모");


    }
}
