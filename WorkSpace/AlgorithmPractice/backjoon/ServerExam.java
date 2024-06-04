package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
    public static void main(String[] args) {
        try(
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        ){
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("클라이언트의 입력 : "+line);
                printWriter.println(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
