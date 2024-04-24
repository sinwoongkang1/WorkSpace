package day10;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCollectionExam {
    public static void wordPrint1(ArrayList<String> stringArrayList){
        System.out.println("모든 단어의 갯수 : "+stringArrayList.size());
        int sum = 0;
        for (int i = 0; i < stringArrayList.toArray().length; i++) {
            System.out.println("입력한 단어 : "+ stringArrayList.get(i)
                    + " 의 글자 수 : "+stringArrayList.get(i).length());
            sum = sum + stringArrayList.get(i).length();
        }
        System.out.println("입력한 모든 단어 글자수의 합 : " + sum);
    }
    public static void findLongWord(ArrayList<String> stringArrayList){
        String longWord = "";
        for (int i = 1; i < stringArrayList.size(); i++) {
            if (stringArrayList.get(i).length() > stringArrayList.get(i - 1).length() ) {
                longWord = stringArrayList.get(i);
            } else if ( stringArrayList.get(i).length() < stringArrayList.get(i - 1).length() ) {
                longWord = stringArrayList.get(i-1);
            }
        }
        System.out.println("가장 긴 단어 : "+ longWord + " 의 길이 : " + longWord.length());
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        ArrayList<String> stringArrayList = new ArrayList<String>();
        boolean value = true;
        while(value) {
            String word = scanner.nextLine();
            if (word.equals("quit")) {
                value = false;
            } else {
                stringArrayList.add(word);
            }
        }
        System.out.println("입력된 단어 : "+stringArrayList);
        wordPrint1(stringArrayList);
        findLongWord(stringArrayList);
    }
}
