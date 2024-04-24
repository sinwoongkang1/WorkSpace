package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class WwwRead {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.naver.com/");
        InputStream urlInput = url.openStream();
        BufferedReader input = new BufferedReader(new InputStreamReader(urlInput));

        String inputLine = input.readLine();
        System.out.println(inputLine);
    }

}