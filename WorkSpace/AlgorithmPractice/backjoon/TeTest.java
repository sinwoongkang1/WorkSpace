package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Scanner;

public class TeTest {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = scanner.nextInt();
            }

            System.out.println(calculator(score));

        }

        public static double calculator(int[] scores) {
            int maxScore = Integer.MIN_VALUE;
            double totalScore = 0;

            for (int i = 0; i < scores.length; i++) {
                maxScore = Math.max(maxScore,scores[i]);
            }

            for (int i = 0; i < scores.length; i++) {
                totalScore += (double) scores[i]/maxScore*100;
            }
            return totalScore/scores.length;
        }
    }
