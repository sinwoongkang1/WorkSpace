package day12;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutExam {
    //원시데이터타입으로 파일에 쓰고 싶다
    public static void main(String[] args) {


        try(FileOutputStream fos = new FileOutputStream("data.text");
            DataOutputStream dos = new DataOutputStream(fos);
                ) {
            dos.writeBoolean(false);
            dos.writeChar('a');
            dos.writeDouble(1.1);



        }
        catch(IOException e) {
            e.printStackTrace();
        }




    }
}
