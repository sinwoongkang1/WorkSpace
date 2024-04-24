package day15;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoServer {
    public static void main(String[] args) {
        //UDP통신. 특정 포트에 DatagramSocket 생성
        try (DatagramSocket datagramSocket = new DatagramSocket(2345)){
            while(true){
                byte[] receiveData = new byte[1024];
                byte[] sendData ;
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                datagramSocket.receive(receivePacket);

                String message = new String(receivePacket.getData()).trim();

                InetAddress clientAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(message.getBytes(),message.getBytes().length,clientAddress,port);
                datagramSocket.send(sendPacket);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
