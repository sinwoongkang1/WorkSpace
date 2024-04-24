package day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam {
    public static void main(String[] args) {
        //파일로 부터 읽어서 FileInputStream
        //파일에 쓴다 FileOutputStream
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null; // 예외 발생부분인 new 생성자 부분을 넘긴다
        try{
            fileIn = new FileInputStream("input.txt");
            fileOut = new FileOutputStream("output.txt");
            int c ;
            while((c=fileIn.read()) != -1) {
                fileOut.write(c);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            if (fileIn != null) {
            try {
                fileIn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//try(여기에서 객체 생성하면 finally 이하 안써도 된다(클로저블 인터페이스가 있는 애들만, 즉 클로져블 메서드가 있는 애들만 여기 쓰면
// 자동으로 클로져블이 실행되도록 하는 것임.내가 클로져블 인터페이스를 구현해서 만들면 여기에 써도 된다.))
// {
// 똑같이
// }