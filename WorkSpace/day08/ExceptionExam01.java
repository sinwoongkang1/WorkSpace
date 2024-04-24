package day08;

public class ExceptionExam01 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작");

        try {
            int i = Integer.parseInt(args[0]);
            System.out.println(10 / i);
        }catch (Exception e) {
            System.out.println("오류내용 :" + e.getMessage());
        }

        System.out.println("프로그램 종료");
    }
}
