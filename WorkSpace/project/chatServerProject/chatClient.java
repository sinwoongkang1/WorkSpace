package project.chatServerProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static project.chatServerProject.chatOption.*;

public class chatClient {
    public static void main(String[] args) {
        String myId = "Kang";
        try(
            Socket socket = new Socket("127.0.0.1",1234);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
                ){
            printWriter.println(myId);
            ClientThread clientThread = new ClientThread(socket,bufferedReader);
            clientThread.start();

            String line = null;
            while ((line = keyboard.readLine()) != null){
                printWriter.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class ClientThread extends Thread {
    Socket socket;
    BufferedReader bufferedReader;

    public ClientThread(Socket socket, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
    }
    @Override
    public void run() {
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                makeSentence(doNotUserWord(makeArrayList(line)));
            }
        }catch(Exception e){
            e.printStackTrace();
            }
        }
    }
