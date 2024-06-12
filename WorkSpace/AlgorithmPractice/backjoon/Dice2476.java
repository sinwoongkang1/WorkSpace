package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Dice2476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int money =0;
        int finalMoney = 0;
        int[] dice = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dice[0] = a;
            dice[1] = b;
            dice[2] = c;
            Arrays.sort(dice);

            if(dice[0]==dice[1] && dice[0]==dice[2]){
                money = dice[0]*1000 + 10000;
            }
            else if(dice[0]==dice[1] || dice[1]==dice[2]){
                money = dice[1]*100 + 1000;
            }else if(dice[0]==dice[1]||dice[0]==dice[2]){
                money = dice[1]*100 + 1000;
            }else
                money = dice[2]*100;

            if (money > finalMoney) {
                finalMoney = money;
            }
        }
        System.out.println(finalMoney);
    }
}
