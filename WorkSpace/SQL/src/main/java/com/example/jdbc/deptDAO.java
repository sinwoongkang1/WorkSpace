package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class deptDAO {
    //칼럼마다 데이터를 추가하려고 하니, 매겨변수로 받아올 값이 너무 많다 -> 데이터를 담은 객체를 보내자
    //VO (value object) DTO (data transfer object) Model, Entity 등의 객체 사용가능 (성격이 각각 다르지만...)

    //입력
    public boolean addDept(DeptDTO deptDTO){
        //1.필요한 객체를 선언한다.
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;

        try {
            //3.접속
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/Mydatabase";
            String user = "kang";
            String password = "kang1234";
            conn = DriverManager.getConnection(dbUrl, user, password);

            //4.쿼리작성
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptDTO.getDeptno());
            ps.setString(2, deptDTO.getDname());
            ps.setString(3, deptDTO.getLoc());

            //5.실행
            int count = ps.executeUpdate();
            System.out.println(count+" inserted.");
            if(count >0){
                flag = true;
            }

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


        return flag;
    }
    //수정
    public boolean updateDept(DeptDTO deptDTO){
        //1.필요한 객체를 선언한다.
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;

        try {
            //3.접속
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/Mydatabase";
            String user = "kang";
            String password = "kang1234";
            conn = DriverManager.getConnection(dbUrl, user, password);

            //4.쿼리작성
            String sql = "update dept set dname = ? where loc=?";
            ps = conn.prepareStatement(sql);
//            ps.setInt(1, deptDTO.getDeptno());
            ps.setString(1, deptDTO.getDname());
            ps.setString(2, deptDTO.getLoc());

            //5.실행
            int count = ps.executeUpdate();
            System.out.println(count+" updated.");
            if(count >0){
                flag = true;
            }

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
        return flag;
    }
    //삭제
    public boolean deleteDept(DeptDTO deptDTO){
        //1.필요한 객체를 선언한다.
        Connection delconn = null;
        PreparedStatement ps = null;
        boolean flag = false;

        try {
            //3.접속
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/Mydatabase";
            String user = "kang";
            String password = "kang1234";
            delconn = DriverManager.getConnection(dbUrl, user, password);

            //4.쿼리작성
            String sql = "delete from dept where deptno = ?";
            ps = delconn.prepareStatement(sql);
            ps.setInt(1,deptDTO.getDeptno());
            //5.실행
            int count = ps.executeUpdate();
            System.out.println(count+" deleted.");
            if(count >0){
                flag = true;
            }
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
        return flag;
    }
    //한건 조회
    public DeptDTO getDept(int deptno){
     return null;
    }
    //모두 조회
    public ArrayList<DeptDTO> getAllDept(){
        return null;
    }

    //조건에 맞는 조회
    public ArrayList<DeptDTO> getDeptByName(String deptName){
        return null;
    }
}

