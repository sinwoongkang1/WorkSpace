package day12;

import java.io.*;

public class IOExam2 {
    public static void main(String[] args)throws Exception {
        //키보드로부터 한줄씩 입력받아서 콘솔에 출력하고 싶다.
        //키보드 System.in
        //한줄씩 읽기위해서 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //버퍼로 읽는다/키보드롤 받는다
        //버퍼드 리더는 데코임, System.in을 이용하려면 컨버터가 필요(InputStreamReader)
        String input = br.readLine(); // 예외처리 해줘야 함
        System.out.println(input);

        BufferedReader br2 = new BufferedReader(new FileReader("a.txt")); //파일로 부터 읽는다
        System.out.println(br2.readLine()); //한줄씩 읽어온 것을 콘솔에 출력하자

    }
}
