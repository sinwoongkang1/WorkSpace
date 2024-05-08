package com.example.jdbc;

public class deptDAORun {
    public static void main(String[] args) {
        DeptDTO dept = new DeptDTO();
        deptDAO dao = new deptDAO();

        //입력
//        dept.setDeptno(90);
////        dept.setDname("HUMAN_RESOURSE");
////        dept.setLoc("MOSCOV");
////        dao.addDept(dept);

        //수정
//        DeptDTO dept2 = new DeptDTO();
//        deptDAO dao2 = new deptDAO();
//        dept2.setLoc("MOSCOV");
//        dept2.setDname("SUPPORT");
//        dao2.updateDept(dept2);

        //삭제
        dept.setDeptno(50);
        dao.deleteDept(dept);
    }
}
