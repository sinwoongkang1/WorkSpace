package WorkSpace.WorkSpace.AlgorithmPractice.Programmers;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] array = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            array[i] = a.charAt(i);
            if(97<=array[i]&& array[i]<=122){
                array[i] = (char)(array[i]-32);
            }else if(65<=array[i] && array[i]<=90){
                array[i] = (char)(array[i]+32);
            }
        }
        for (int i = 0; i < a.length(); i++) {
            System.out.print(array[i]);
        }
    }
}

