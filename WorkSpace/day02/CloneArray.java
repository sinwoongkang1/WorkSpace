package ch02;

public class CloneArray {
    public static void main(String[] args) {
        int [] arry = {10,20,30,40};
        int [] arry2 = arry.clone();

        arry2[1] = 50;

        System.out.println(arry[1]);
        System.out.println(arry2[1]);
    }
}

