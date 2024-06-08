package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayCount = sc.nextInt();
        int[] array = new int[arrayCount];
        int[] array2 = new int[arrayCount];

        for (int i = 0; i < arrayCount; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < arrayCount; i++) {
            array2[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));

        int[] array3 = new int[arrayCount];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {

            }
        }


        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + (array[i]*array2[i]);
        }
        System.out.println(sum);
    }
}
