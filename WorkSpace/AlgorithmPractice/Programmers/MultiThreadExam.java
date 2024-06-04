package WorkSpace.WorkSpace.AlgorithmPractice.Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadExam {
    public static void main(String[] args) {
    try(
    ServerSocket serverSocket = new ServerSocket(9999);
    ){
        Socket socket = serverSocket.accept();
        EchoThread echoThread = new EchoThread(socket);
        echoThread.start();
    }catch(Exception e){
    e.printStackTrace();
        }
    }
}
class EchoThread extends Thread {
    private Socket socket;
    EchoThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try(
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            ){
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("클라이언트의 입력 : "+line);
                printWriter.println(line);
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