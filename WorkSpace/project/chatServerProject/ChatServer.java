package project.chatServerProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;
import java.util.stream.Collectors;

import static project.chatServerProject.chatOption.*;

public class ChatServer {
    static Map<String, PrintWriter> allClients = new HashMap<>();
    static ArrayList<Map<String, Integer>> chatRoomList = new ArrayList<>();
//    static Map<String, Integer> chatRoom = new HashMap<>();
    public static void main(String[] args) {
        try (
            ServerSocket serverSocket = new ServerSocket(12345);
        ) {
            System.out.println("***Chat Server Ready***");
            while (true) {
                Socket socket = serverSocket.accept();
                ChatThread chatThread = new ChatThread(socket,allClients);
                chatThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //방 생성 메서드
//    public static void createChatRoom(String roomName, int roomNum) {
//        Map<String, Integer> room = new HashMap<>();
//        room.put(roomName, roomNum);
//        chatRoomList.add(room);
//        System.out.println("방 번호 " + roomNum + " 가 생성되었습니다.");
////        System.out.println(chatRoomList);
//    }
    //리스트에서 같은 방 번호로 저장된 key들 에게만 메시지 전송 메서드
//public static void broadcastToRoom(int roomNumber, String message) {
//    for (Map<String, Integer> room : chatRoomList) {
//        if (room.containsValue(roomNumber)) {
//            for (String clientId : room.keySet()) {
//                PrintWriter clientWriter = allClients.get(clientId);
//                clientWriter.println(message);
//
//            }
//            break;
//        }
//    }
//}
}

class ChatThread extends Thread {
Socket socket;
String id;
ArrayList<Map<String, Integer>> chatRoomList ;
Map<String, Integer> chatRoom;
Map<String,PrintWriter> map ;
BufferedReader bufferedReader;
PrintWriter printWriter;

    public ChatThread(Socket socket, Map<String, PrintWriter> map) {
        this.socket = socket;
        this.map = map;
        this.chatRoomList = new ArrayList<>();
        this.chatRoom = new HashMap<>();


        try{
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);
            while (true) {
                id = bufferedReader.readLine();
                if (id == null) {
                    // 닉네임 입력 오류 처리
                    printWriter.println("입력 오류가 발생했습니다. 다시 시도해주세요.");
                } else if (map.containsKey(id)) {
                    // 이미 존재하는 닉네임인 경우 처리
                    printWriter.println("이미 사용 중인 닉네임입니다. 다른 닉네임을 입력해주세요.");
                } else {
                    System.out.println(id + " 닉네임의 사용자가 연결했습니다."); //서버에 출력
                    System.out.println(id +" 의 IP : "+ socket.getInetAddress());
                    printWriter.println("당신의 닉네임은 : "+ id + " 입니다.");
                    map.put(id, printWriter);
                    break;
                }
            }
            broadCast(id + " 닉네임의 사용자가 연결했습니다."); //채팅방에 전송

//            printWriter.println("방 목록 보기 : /list\n 방 생성 : /create\n 방 입장 : /join\n 방 나가기 : /exit\n 접속종료 : /bye ");

        }catch(SocketException e){
            System.out.println("채팅 프로그램을 종료합니다.");
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    @Override
    public void run() {
        try{
            String line = null;
            while ( (line = bufferedReader.readLine()) != null ) {
//                if(line.startsWith("/create")){
//                    Integer roomNum = Integer.valueOf(bufferedReader.readLine());
//                    System.out.println(roomNum+" 번 채팅방이 생성되었습니다.");
//                }
                if(line.startsWith("/bye")){
                    System.exit(1);
                    break;
                }
//                if(line.startsWith("/join")){
//                int roomNum = Integer.parseInt(bufferedReader.readLine());//방 번호를 받는다
//                chatRoom.put(id, roomNum); //닉네임과 방 번호를 저장한다
//                chatRoomList.add(chatRoom);//리스트에 저장한다
//                printWriter.println(roomNum + " 번 채팅방에 참가합니다");//방 번호를 다시 보낸다
//                ChatServer.broadcastToRoom(roomNum,line);
//                }
                makeSentence(doNotUserWord(makeArrayList(id + " : " + line)));
                broadCast(id + " : " + line);
            }

        } catch (SocketException socketException){
            System.out.println(id +" 닉네임의 사용자가 연결을 끊었습니다");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void broadCast(String message) {
        for (PrintWriter chat : map.values() ) {
            chat.println(message);
        }
    }
}