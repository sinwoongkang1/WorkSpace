package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class echoThreadServer {
    public static void main(String[] args) {

        try(
            //1.서버 소켓 생성 (1개)
            ServerSocket serverSocket = new ServerSocket(1234);
            ){
            //2.클라이언트 소켓을 받이들이고 기다림 = 클라 수만큼 진행 돼야 함
            //클라이언트마다 각자 실행할 수 있도록 해야 함 = 쓰레드
            while (true) {
                Socket socket = serverSocket.accept();
                EchoThread echoThread = new EchoThread(socket);
                echoThread.start();
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}

class EchoThread extends Thread {
private Socket socket;
EchoThread(Socket socket){
    this.socket = socket;
}
    @Override
    public void run() {
        System.out.println(socket.getInetAddress().getHostAddress() + " 로 부터 연결되었습니다");

        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
                ){
            String line = null;
            ArrayList<String> chats = new ArrayList<>();
            while ((line = br.readLine())!=null){
                System.out.println(socket.getInetAddress().getHostName()+" 클라이언트로 부터 받은 메시지 : "+line);
                chats.add(line);
                pw.print(chats);
//
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}