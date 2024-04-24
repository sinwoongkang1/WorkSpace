package day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class echoClientExam {
    public static void main(String[] args) throws Exception{
        //1.소켓 생성
        Socket socket = new Socket("127.0.0.1",1234);
        System.out.println("Client_1 연결 성공");
        //2.통로를 연다(데이터 읽고 쓰기).
        //쓰기
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        //읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //클라가 키보드를 통해 입력하기 위한 통로
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while((line= keyboard.readLine())!=null) {
            if(line.equalsIgnoreCase("quit")){
                System.out.println("서버를 종료합니다");
                break;
            }

        //서버에게 보냄
        pw.println(line);
        pw.flush();  //버퍼가 쌓여서 보내는데, 안쌓이면 안보내는걸 방지하기 위해

        //서버에서 받음
        String echo = br.readLine();
        System.out.println(echo);
        }

        //연결 종료
        pw.close();
        br.close();
        keyboard.close();
        socket.close();
    }
}
