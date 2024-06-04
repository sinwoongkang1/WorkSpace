package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test1427 {
    public static void main(String[] args) {
        //1.사용자로 부터 정수를 입력받는다.
        Scanner sc = new Scanner(System.in);
        System.out.println("예제를 입력하세요");
        int n = sc.nextInt();

        System.out.println("입력한 수 : "+n);

        //2.입력한 정수를 문자로 변환
        String number = String.valueOf(n);

        Integer[] arr = new Integer[number.length()];
        for (int i = 0; i < number.length() ; i++) {
            arr[i] = number.charAt(i)-48;
        }
        System.out.println("배열에 올바르게 들어갔나 확인 : "+Arrays.toString(arr));

        //숫자를 오름차순으로 정리하면 끝
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("배역을 역순으로 정렬"+Arrays.toString(arr));

        //반복문으로 정수로 출력
        System.out.println("=====예 제 출 력=====");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}