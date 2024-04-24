package WorkSpace.WorkSpace.AlgorithmPractice;

import java.util.Random;

public class BaekJoon {
    static int yootSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
    static void whatIsYoot(int sum) {
        if (sum==0) {
            System.out.println("윷");
        } else if (sum == 1) {
            System.out.println("도");
        } else if (sum ==2) {
            System.out.println("개");
        } else if (sum==3) {
            System.out.println("걸");
        } else
            System.out.println("모");
    }

    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(2);
        int b = random.nextInt(2);
        int c = random.nextInt(2);
        int d = random.nextInt(2);
        int a1 = random.nextInt(2);
        int a2 = random.nextInt(2);
        int a3 = random.nextInt(2);
        int a4 = random.nextInt(2);
        int b1 = random.nextInt(2);
        int b2 = random.nextInt(2);
        int b3 = random.nextInt(2);
        int b4 = random.nextInt(2);

        int[] array1 = {a, b, c, d,};
        int[] array2 = {a1, a2, a3, a4};
        int[] array3 = {b1, b2, b3, b4};

        int e1 = yootSum(array1);
        int e2 = yootSum(array2);
        int e3 = yootSum(array3);

        for (int i = 0; i < array1.length; i++) {
                System.out.print(array1[i] + " ");
            }
        whatIsYoot(e1);
        for (int j = 0; j < array2.length; j++) {
            System.out.print(array2[j] + " ");
        }
        whatIsYoot(e2);
        for (int k = 0; k < array3.length; k++) {
            System.out.print(array3[k] + " ");
        }
        whatIsYoot(e3);
    }
}

