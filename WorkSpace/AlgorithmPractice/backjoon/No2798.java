package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Scanner;

public class No2798 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
        int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
    }
    int result = solve(N, M, arr);
        System.out.println(result);
    }
    public static int solve(int N, int m, int[] arr) {
        int answer = 0;
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            for (int k = j + 1; k < N; k++) {
                if (arr[i] + arr[j] + arr[k] <= m) {
                    answer = Math.max(answer, arr[i] + arr[j] + arr[k]);
                }
            }
        }
    }return answer;
    }
}
