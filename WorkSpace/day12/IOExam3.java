package day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class IOExam3 {
    public static void main(String[] args) {

    try(BufferedReader fr = new BufferedReader(new FileReader("test.txt"));
        PrintWriter fw = new PrintWriter("testhi.txt");){

        String line;
        while((line=fr.readLine())!= null){
            fw.println(line+"hi");
        }


    }catch(Exception e)
    {e.printStackTrace();
    }






    }
}
