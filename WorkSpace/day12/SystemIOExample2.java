package day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SystemIOExample2 {
    public static void main(String[] args) { //입력해서 파일에 쓰기
        try(BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter("output.txt");
        ) {
            System.out.println("문자를 입력하세요");
            int count=0;
            String input = "";
            ArrayList<String> data = new ArrayList<>();
            while (count<5) {
                input = reader.readLine();
                count++;
                data.add(input);
            }
            for (int i = 0; i < 5; i++) {
            System.out.println(data.get(i));
            writer.println(data.get(i));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
