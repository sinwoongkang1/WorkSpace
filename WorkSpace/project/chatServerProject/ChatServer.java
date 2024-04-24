package project.chatServerProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import static project.chatServerProject.chatOption.*;

public class ChatServer {
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(1234);
        ) {
            Map<String, PrintWriter> allClients = new HashMap<>();
            System.out.println("***Diet Chat Server Ready***");
            while (true) {
                Socket socket = serverSocket.accept();
                ChatThread chatThread = new ChatThread(socket,allClients);
                chatThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class ChatThread extends Thread {
Socket socket;
String id;
Map<String,PrintWriter> map ;
BufferedReader bufferedReader;
PrintWriter printWriter;
    public ChatThread(Socket socket, Map<String, PrintWriter> map) {
        this.socket = socket;
        this.map = map;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);
            id = bufferedReader.readLine();
            broadCast(id + "입장");
            map.put(this.id,printWriter);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try{
            String line = null;
            while ( (line = bufferedReader.readLine()) != null ) {
                makeSentence(doNotUserWord(makeArrayList(id+" : "+line)));
                broadCast(id+" : "+line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void broadCast(String msg) {
        for (PrintWriter printWriter1 : map.values() ) {
            printWriter1.println(msg);
        }
    }
}