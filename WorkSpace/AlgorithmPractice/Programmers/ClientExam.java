package WorkSpace.WorkSpace.AlgorithmPractice.Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
    public static void main(String[] args) {
        try(
            Socket socket = new Socket("127.0.0.1",9999);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
                ){
            String line = null;
            while ((line = keyBoard.readLine()) != null) {
                printWriter.println(line);
                String echo = bufferedReader.readLine();
                System.out.println("서버로 부터 받은 메시지 : "+echo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
