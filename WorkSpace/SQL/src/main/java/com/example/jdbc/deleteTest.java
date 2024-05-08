package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteTest {
    public static void main(String[] args) {
        //1.필요한 객체를 선언한다.
        Connection delconn = null;
        PreparedStatement ps = null;

        try {
            //3.접속 (아까 쓴거)
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/Mydatabase";
            String user = "kang";
            String password = "kang1234";
            delconn = DriverManager.getConnection(dbUrl, user, password);

            //4.쿼리작성
            String sql = "delete from dept where deptno=90";
            ps = delconn.prepareStatement(sql);
            //5.실행
            int count = ps.executeUpdate();
            System.out.println(count+" deleted.");
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
            if(delconn != null) {
                try {
                    delconn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    }
