package day12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTMLReader {

    public static void main(String[] args) {
        try {
            // URL 객체 생성
            URL url = new URL("http://www.naver.com");

            // URLConnection 열기
            URLConnection conn = url.openConnection();

            // 입력 스트림을 열어서 HTML 소스 읽기
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            StringBuilder htmlContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                htmlContent.append(line);
                htmlContent.append("\n");
            }
            reader.close();

            // HTML 소스 출력
            System.out.println(htmlContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
