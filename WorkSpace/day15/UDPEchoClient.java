package day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) {
        try(DatagramSocket clientSocket = new DatagramSocket(2345);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))
        ){
            //서버의 주소 설정
            InetAddress IpAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];

            //키보드로 입력 받아서 보낸다
            System.out.println("보낼 메시지를 입력하세요");
            String message = bufferedReader.readLine();
            //서버로 보내기
            DatagramPacket sendPacket = new DatagramPacket(message.getBytes(),message.getBytes().length,IpAddress,8888);
            clientSocket.send(sendPacket);

            //서버로 받기
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String receiveMessage = new String(receivePacket.getData()).trim();


            System.out.println(receiveMessage);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
