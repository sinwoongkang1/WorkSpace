package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        //아이디가 처음에 입력되게 하기 위해서 args[0] 에서 받아오는 것으로 구현해봅시다.
        if (args.length != 1) {
            System.out.println("사용법 : java ChatClent id");
            System.exit(1);
        }

        try (Socket socket = new Socket("127.0.0.1", 1111);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ) {
            //접속되면 id를 서버에 보낸다. (서버와의 약속!!)
            printWriter.println(args[0]);

            //네트워크에서 입력된 내용을 담당하는 부분을 Thread로..
            new InputThread(socket, bufferedReader).start();

            //키보드로부터 입력받은 내용을 서버에 보내는코드
            String msg = null;
            while ((msg = keyboard.readLine()) != null) {
                printWriter.println(msg);
                if ("/quit".equalsIgnoreCase(msg))
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class InputThread extends Thread {
    private Socket socket;
    private BufferedReader bufferedReader;

    InputThread(Socket socket, BufferedReader in) {
        this.socket = socket;
        this.bufferedReader = in;
    }

    @Override
    public void run() {
        try {
            String msg = null;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
