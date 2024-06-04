package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class FindStudent {

public static void arrayReverse(int[] array) {
    int space ;
    for (int i = 0; i < array.length/2; i++) {
        space = array[i];
        array[i] = array[array.length-i-1];
        array[array.length-i-1] = space;
    }
}
    public static void find (int[] array, int[]array2) {
        Arrays.sort(array);
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));

        int key = 0;
        for (int i = 0; i < array2.length; i++) {
            if (array[i] != array2[i]) {
                System.out.println(array[i]);
                key = array[i];
                break;
            }
        }
        arrayReverse(array);
        arrayReverse(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < array2.length; i++) {
            if (array[i] != array2[i]) {
                System.out.println(array[i]);
                break;

            }

        }

    }


    public static void main(String[] args) {
        int[] student = new int[30];
        for (int i = 0; i < student.length; i++) {
            student[i] = i+1;
        }
        int[] homeworkStudent = new int[28];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < homeworkStudent.length ; i++) {
            int a = scanner.nextInt();
            homeworkStudent[i] = a ;
        }

        find(student,homeworkStudent);
    }
}
