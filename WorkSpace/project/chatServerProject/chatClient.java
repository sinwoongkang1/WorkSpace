package project.chatServerProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static project.chatServerProject.chatOption.*;

public class chatClient {
    public static void main(String[] args) {
        try(
            Socket socket = new Socket("127.0.0.1",12345);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
                ){
            System.out.println("채팅방에서 사용할 닉네임을 입력해주세요");
            String myNickName = keyboard.readLine();
            printWriter.println(myNickName);
            //서버로 읽어오기
            String firstId = bufferedReader.readLine();
            if (firstId.length()>0) {
                System.out.println("처음 생성할 채팅방 번호를 입력해주세요");
                int roomNumber = Integer.parseInt(keyboard.readLine());
                printWriter.println(roomNumber);
            }
            ClientThread clientThread = new ClientThread(socket,bufferedReader);
            clientThread.start();

            //써서 내보내기
            String line = null;
            while ((line = keyboard.readLine()) != null){
                if(line.equals("/bye")) {
                    System.out.println("연결을 종료합니다.");
                    System.exit(1);
                    break;
                }
                if(line.equals("/create")){
                    printWriter.println(line);
                    System.out.println("생성할 방 번호를 입력하세요");
                    int newRoomNumber = Integer.parseInt(keyboard.readLine());
                    printWriter.println(newRoomNumber);
                }
                if(line.equals("/list")){
                    printWriter.println("/list"); //서버에 /list를 보낸다.
                    String rooms = bufferedReader.readLine(); // 서버로부터 방 목록을 받습니다.
                    System.out.println(rooms); // 받은 방 목록을 출력합니다.
                }
                if(line.startsWith("/join")) {
                    printWriter.println("/join");
                    System.out.println(bufferedReader.readLine());
                    String userInput;
                    while ((userInput = keyboard.readLine()) != null) {
                        printWriter.println(userInput);
                    }

                }
                String userInput;
                while ((userInput = keyboard.readLine()) != null) {
                    printWriter.println(userInput);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
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
