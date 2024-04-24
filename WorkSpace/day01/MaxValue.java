package ch01;

import java.util.Scanner;

public class MaxValue {

    public static int maxValue(int a,int b,int c) {
        if (a>b) {
            if(b>c){
                return a;
            }else{
                if(a>c){
                    return a ;}
                else {
                    return c;}
            }
        }else{
            if(b>c){
                return b;}
            else{
                return c;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("정수 3가지를 입력하세요");
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2= new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc1.nextInt();
        int c = sc2.nextInt();


        System.out.println("입력한 수 중의 최대값은 : " + maxValue(a,b,c));
    }

}
