package day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class echoClientExam2 {
    public static void main(String[] args) {
        try(
            Socket socket = new Socket("127.0.0.1",1234);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ){
            System.out.println("Client_2 연결 성공");
            String line = null;
            while ((line= keyboard.readLine())!=null) {
                if(line.equalsIgnoreCase("quit")){
                    System.out.println("서버를 종료합니다");
                    break;
                }
                pw.println(line);
                pw.flush();
                String echo = br.readLine();
                System.out.println("서버로 부터 받은 메시지 : " + echo);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
        }
    }
}
