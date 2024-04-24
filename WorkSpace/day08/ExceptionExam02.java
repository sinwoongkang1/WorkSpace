package day08;


import java.util.Scanner;

public class ExceptionExam02 {
 public void inputScore(int score){
     if (score<0 || score>100){
//         System.out.println("You Can Input Score Over 0 or Under 100");
//         return;
         throw new MyException("Checking Your Score~");
     }
     System.out.println("This is Your Score : "+score);
 }

    public static void main(String[] args) {
        ExceptionExam02 ex = new ExceptionExam02();
        System.out.println("Input Your Score!!");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        try{ex.inputScore(score);}
        catch(MyException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Main Exit");
    }

}
