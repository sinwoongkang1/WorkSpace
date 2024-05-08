package com.example.jdbc;

import java.sql.*;

public class selectTest {
    public static void main(String[] args) {
        Connection selconn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/Mydatabase";
            String user = "kang";
            String password = "kang1234";
            //3.접속
            selconn = DriverManager.getConnection(dbUrl, user, password);
            //4.쿼리작성
            ps = selconn.prepareStatement("select deptno,dname,loc from dept where deptno=10");
            //5.쿼리실행
            rs = ps.executeQuery();
            //6.결과 얻어냄
            while(rs.next()){
                System.out.print(rs.getInt("deptno")+"   ");
                System.out.print(rs.getString("dname")+"   ");
                System.out.print(rs.getString("loc")+'\n');
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                selconn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
