package day15;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    public static void main(String[] args) {
        try(
        //1.서버소켓 생성
        ServerSocket serverSocket = new ServerSocket(1111);
        ) {//2.accept()
            System.out.println("***** My Server Ready *****");
            Map<String,PrintWriter> chatClients = new HashMap<>();//공유자원
            while(true) {
                Socket socket = serverSocket.accept();
                new ChatThread(socket,chatClients).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class ChatThread extends Thread{
    Socket socket;
    String id;
    Map<String,PrintWriter> chatClients;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public ChatThread(Socket socket, Map<String, PrintWriter> chatClients) {
        this.socket = socket;
        this.chatClients = chatClients;
        try//클라이언트가 생성될 때 클라이언트로 부터 아이디를 얻어온다.
        {
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(socket.getOutputStream(),true);
        //클라이언트가 접속하자 마자 아이디를 보내야 한다.
        id = bufferedReader.readLine();//보낸 아이디를 읽는다
        broadcast(id+" In"); //모두에게 알린다.
        System.out.println("New user : "+id);//서버에도 쓴다
        //동기화 = 풋 할때 다른 메서드 들은 기다려
        synchronized (chatClients) {
        chatClients.put(this.id, printWriter);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try{
            String line ;
            while((line=bufferedReader.readLine()) != null){
                if("quit".equalsIgnoreCase(line)){
                    break;
                }
                if(line.indexOf("to")==0){
                    sendMsg(line);
                } else
                broadcast(id+" : "+line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {//while 문 종류되면 실행된다
            synchronized (chatClients){
                chatClients.remove(id);
            }
            broadcast(id +" is Exit");
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //전체 사용자에게 메세지를 뿌리는 메서드
    public void broadcast(String msg){
    for(PrintWriter chat : chatClients.values()){
    chat.println(msg);
}
    }
    //특정 사용자에게만 메시지를 보내는 메서드
    public void sendMsg (String msg) {
       int firstSpaceIndex = msg.indexOf(" ");
       if (firstSpaceIndex == -1 ) return;
       int secondSpaceIndex = msg.indexOf(" ",firstSpaceIndex+1);
        if (secondSpaceIndex == -1 ) return;
        String to = msg.substring(firstSpaceIndex+1,secondSpaceIndex);
        String message = msg.substring(secondSpaceIndex+1);
        PrintWriter pw = chatClients.get(to);
        if (pw != null){
            pw.println(id+" 님으로 부터 온 귓속말 : "+message);
        }else{
            System.out.println(to+" 를 찾을 수 없음");
        }


    }
}
