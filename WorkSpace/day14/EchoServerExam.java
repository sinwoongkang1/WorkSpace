package day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerExam {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(9999);
        System.out.println("1.서버 준비 완료");
        Socket socket = server.accept(); //대기,클라이언트 소켓 리턴
        System.out.println(socket.getInetAddress().getHostAddress()+"로 부터 연결 완료");
        System.out.println("2.클라 연결수락, 클라 소켓 얻어오기 완료");
        //데이터를 읽고 쓰기
        //입력통로
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //출력통로
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println("클라이언트로 부터 받은 메시지 : " + line  );
            //입력받은 값을 다시 내보내주기
            pw.println(line);
            pw.flush();
        }

        br.close();
        pw.close();
        socket.close();
    }
}
