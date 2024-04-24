package ch02;

public class ArraysSum {
    public static void main(String[] args) {
        int [] numbers = {5,10,15,20,25};
        //배열의 각 요소 출력

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();

        //배열의 각 요소의 합 출력
        int sum = 0 ;
        for (int i = 0; i < numbers.length ; i++) {
            sum = sum + numbers[i] ;

        }System.out.println(sum);


    }
}
