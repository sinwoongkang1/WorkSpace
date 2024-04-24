package day10;

import java.util.ArrayList;
import java.util.Scanner;

public class CollectionExam {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
       boolean flag = true;
        System.out.println("값을 입력하세요");
       try {
           while (flag) {
               int number = scanner.nextInt();
               if (number < 0 || number > 100) {
                   System.out.println("0 이상 100 이하의 수를 입력하세요. 입력한 값 : " + number);
                   continue;
               } else if (number > 0 && number < 100) {
                   integerArrayList.add(number);
               } else if (number == 0) {
                   integerArrayList.remove(Integer.valueOf(0));
                   flag = false;
               }
           }
       }catch (Exception e) {
           System.out.println(e.getMessage());
       }
       int sum = 0;
        for (int i = 0; i <integerArrayList.toArray().length; i++) {
            sum = sum + integerArrayList.get(i);
        }
        System.out.println("입력한 값의 총 합");
        System.out.println(sum);
        int value = integerArrayList.size();
        System.out.println("입력한 값의 평균");
        System.out.println(sum/value);
    }
}
