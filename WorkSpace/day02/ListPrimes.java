package ch02;

public class ListPrimes {
    public static void main(String[] args) {
        for (int i = 2; i <=10 ; i++) {
            for (int j = 2; j <i ; j++) {
                if (j % i ==0) {

                }else{
                    System.out.println(i);
                }
            }

        }
    }
}
