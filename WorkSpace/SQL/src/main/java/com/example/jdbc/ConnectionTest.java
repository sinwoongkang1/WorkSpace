package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        //0.라이브러리 셋팅, 드라이버 로딩
        Class.forName("com.mysql.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost:3306/Mydatabase";
        String user = "kang";
        String password = "kang1234";

        //1.접속 객체 얻어오기
        Connection con = DriverManager.getConnection(dbUrl, user, password);
        if (con != null) {
            System.out.println("^_^");
        }else
            System.out.println("ㅠ_ㅠ");
    }
}
