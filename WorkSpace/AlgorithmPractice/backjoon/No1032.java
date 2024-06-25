package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class No1032 {
    public static void main(String[] args) {
        ArrayList<String> filenames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String filename = sc.nextLine();
            filenames.add(filename);
        }

        int length = filenames.get(0).length();
        StringBuilder pattern = new StringBuilder(filenames.get(0));

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < n; j++) {
                if (filenames.get(j).charAt(i) != filenames.get(0).charAt(i)) {
                    pattern.setCharAt(i, '?');
                    break;
                }
            }
        }
        System.out.println(pattern.toString());

    }
}

