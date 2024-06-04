package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Scanner;

public class beakjoon5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] inputs = new String[3][4];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = scanner.nextLine().split(" ");
        }

        for (int i = 0; i < inputs.length; i++) {
            int front = 0; // 0
            int back = 0; // 1
            for (int j = 0; j < inputs[i].length; j++) {
                if (inputs[i][j].equals("0")) {
                    front++;
                } else {
                    back++;
                }
            }

            if (front == 1) {
                System.out.println("A");
            } else if (front == 2) {
                System.out.println("B");
            } else if (front == 3) {
                System.out.println("C");
            } else if (front == 4) {
                System.out.println("D");
            }

            if (back == 4) {
                System.out.println("E");
            }
        }
    }
}