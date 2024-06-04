package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ThreeNumber {

    public static void main(String[] args) {
        Integer[] nums = new Integer[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = sc.nextInt();
        }
        //입력한 정수가 제대로 들어갔나 확인
        System.out.println("입력한 세 정수가 배열로 잘 들어갔나 확인");
        System.out.println(Arrays.toString(nums));

        System.out.println();
        System.out.println("배열을 역순으로 정렬하고 2번째 인덱스 값을 출력한다.");
        //정수 배열을 역순으로 정렬하여 인덱스 1번째를 출력하면 2번째로 큰 수가 됨.
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println(nums[1]);

    }
}
