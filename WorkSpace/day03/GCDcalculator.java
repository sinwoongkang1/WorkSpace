package ch03;

public class GCDcalculator {
    static int gcdCalculator(int a, int b) {
        if (b==0) {
            return a ;
        } else {
            return gcdCalculator(b, a%b);
        }
    }

    public static void main(String[] args) {
        int a = gcdCalculator(90,8);
        System.out.println(a);
    }
}
