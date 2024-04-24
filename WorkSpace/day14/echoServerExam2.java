package day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class echoServerExam2 {
    public static void main(String[] args) {

        try(
                ServerSocket socketsocket = new ServerSocket(9999);
                Socket socket = socketsocket.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
                ){
            String line = null;
            while ( (line = br.readLine()) != null) {
                System.out.println("클라이언트의 메시지 : "+line);
                pw.println(line);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {

        }


    }
}
