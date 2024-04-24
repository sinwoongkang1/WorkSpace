package day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws Exception {
//        System.out.println(System.getProperty("user.dir"));
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");
        byte[] bytes = new byte[8];
        int n;
        while ((n=fileInputStream.read(bytes)) != -1 ) { // -1이면 읽을것이 없다는 뜻, byte 배열 크기만큼 한번에 읽음
            String str = new String(bytes);
            System.out.println(bytes); // 콘솔에 쓰기 (읽은 bytes)
            System.out.println(str); //콘솔에 쓰기 (문자열로)
            fileOutputStream.write(bytes); // 쓰기
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
