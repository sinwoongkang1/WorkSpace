package day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SystemIOExample {
    public static void main(String[] args) {
        //키보드(System.in)로부터 한 줄(BufferedReader) 입력을 받기 위한 IO객체를 생성
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("문자열을 입력하세요. ");
            String userInput = reader.readLine();
            System.out.println("입력한 문자열 : " + userInput);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
