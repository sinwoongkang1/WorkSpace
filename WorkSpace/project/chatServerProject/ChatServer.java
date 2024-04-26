package project.chatServerProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

import static project.chatServerProject.chatOption.*;

public class ChatServer {
    static Map<String, PrintWriter> allClients = new HashMap<>();
    static Map<Integer, Map<String,PrintWriter>> chatRoomList = new HashMap();
    public static void main(String[] args) {
        try (
            ServerSocket serverSocket = new ServerSocket(12345);
        ) {
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
    public static void createChatRoom(int roomNum, Map<String, PrintWriter> map) {
        chatRoomList.put(roomNum, map);
        System.out.println("방 번호 " + roomNum + " 가 생성되었습니다.");
        System.out.println(ChatServer.getChatRoomList());
        System.out.println(ChatServer.chatRoomList.values());
    }
    public static String getChatRoomList() {
        return chatRoomList.keySet().toString();
    }
    public static String extractNumbers(String input) {
        StringBuilder numbers = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.append(c);
            }
        }
        return numbers.toString();
    }
}
class ChatThread extends Thread {
Socket socket;
String id;
Map<Integer, Map<String,PrintWriter>> chatRoomList ;
Map<String,PrintWriter> map ;
BufferedReader bufferedReader;
PrintWriter printWriter;
    public ChatThread(Socket socket, Map<String, PrintWriter> map) {
        this.socket = socket;
        this.map = map;
        this.chatRoomList = new HashMap<>();

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
                    // 닉네임을 사용자 목록에 추가하고 반복문 종료
                    map.put(id, printWriter);
                    break;
                }
            }
//            broadCast(id + " 닉네임의 사용자가 연결했습니다."); //채팅방에 전송
            System.out.println(id + " 닉네임의 사용자가 연결했습니다."); //서버에 출력
            System.out.println(id +" 의 IP : "+ socket.getInetAddress());
            printWriter.println(ChatServer.chatRoomList);
            String firstRoomMake = bufferedReader.readLine();
            ChatServer.createChatRoom(Integer.parseInt(firstRoomMake),map);


            while(true) {
                printWriter.println("방 목록 보기 : /list\n 방 생성 : /create\n 방 입장 : /join [방번호]\n 방 나가기 : /exit\n 접속종료 : /bye "
                );
                //-----사용자로 부터 입력이 온다-------
                String line = bufferedReader.readLine();
                if (line.equals("/list")) {//입력이 /list로 들어오면
                    System.out.println(ChatServer.getChatRoomList()); // 서버에서 방 목록 출력
                    printWriter.println(ChatServer.getChatRoomList()); // 클라이언트에게 방 목록 전송
                }
                if (line.equals("/create")) {
                    int roomNum = Integer.parseInt(bufferedReader.readLine());
                    ChatServer.createChatRoom(roomNum,map);
                    map.put(this.id, printWriter); // 방에 현재 사용자 추가
                    printWriter.println("방 번호 " + roomNum + " 가 생성되었습니다.");
                    printWriter.println(roomNum + "번 채팅방에 입장하였습니다.");
                    String msg = null;
                    while ((msg = bufferedReader.readLine()) != null) {
                        makeSentence(doNotUserWord(makeArrayList(id+" : "+msg)));
                        broadCast(id+" : "+msg);
                    }

                }
                if (line.startsWith("/join")) {
                    String result = ChatServer.extractNumbers(bufferedReader.readLine());
                        int roomNumber = Integer.parseInt(result);
                        printWriter.println("입력한 방 번호는 " + roomNumber + "입니다.");
                        map.put(this.id,printWriter);
                        chatRoomList.put(roomNumber,map);
                        broadCast(this.id + ","+roomNumber+ " 번 채팅방에 입장하였습니다.");



                }
            }


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
                makeSentence(doNotUserWord(makeArrayList(id+" : "+line)));
                broadCast(id+" : "+line);

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