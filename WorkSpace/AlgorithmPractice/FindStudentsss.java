package WorkSpace.WorkSpace.AlgorithmPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FindStudentsss {

    public static void find(int[] array, int[] array2) {

        int[] array3 = new int[array.length+ array2.length];
        //새로운 array3 생성
        for (int i = 0; i < array.length; i++) {
            array3[i] = array[i];
        }
        for (int j = array.length; j < array3.length; j++) {
            array3[j] = array2[j- array.length];
        }
        //array3에 요소 입력
        Arrays.sort(array3); //array3 정렬
        System.out.println(Arrays.toString(array3));
        //중복요소 제거
        for (int i = 1; i < array3.length; i++) {
            if(array3[i-1]==array3[i]){
                array3[i-1] = 0 ;
                array3[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array3));
        // 0인 것들 제거
        for (int i = 0; i < array3.length; i++) {
            if(array3[i] != 0) {
                System.out.println(array3[i]);
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
        for (int i = 0; i < homeworkStudent.length; i++) {
            int a = scanner.nextInt();
            homeworkStudent[i] = a;
        }
        System.out.println(Arrays.toString(student));
        System.out.println(Arrays.toString(homeworkStudent));
        find(student,homeworkStudent);

    }
}