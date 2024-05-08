package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) {
        //1.필요한 객체를 선언한다.
     Connection conn = null;
     PreparedStatement ps = null;

     try {
         //3.접속 (아까 쓴거)
         Class.forName("com.mysql.jdbc.Driver");
         String dbUrl = "jdbc:mysql://localhost:3306/Mydatabase";
         String user = "kang";
         String password = "kang1234";
         conn = DriverManager.getConnection(dbUrl, user, password);

         //4.쿼리작성
         String sql = "insert into dept(deptno,dname,loc) values(60,'SALES','TOKYO')";
         ps = conn.prepareStatement(sql);
         //5.실행
         int count = ps.executeUpdate();
         System.out.println(count+" inserted.");
     }catch(Exception e) {
         e.printStackTrace();
     }finally {
         //2.미리 닫아준다
         //나중에 연 것을 먼저 닫아준다 (순서대로)
         if(ps != null) {
             try {
                 ps.close();
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
         if(conn != null) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
     }
    }
}
