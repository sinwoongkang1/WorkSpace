package day13;

class myRunnable implements Runnable {
    public void run() {
        System.out.println("엄마가 청소 시작");
        for (int i = 0; i < 10; i++) {
            System.out.println("엄마 청소 중");
        }
        System.out.println("엄마 청소 끝");
    }
}
class kangRunnable2 implements Runnable {
    public void run() {
        System.out.println("아빠가 청소 시작");
        for (int i = 0; i < 10; i++) {
            System.out.println("아빠 청소 중");
        }
        System.out.println("아빠 청소 끝");
    }
}
public class RunnalbeExam {
    public static void main(String[] args) {
        System.out.println("내가 청소 시작");
        Thread t1 = new Thread(new myRunnable());
        t1.start();
        Thread t2 = new Thread(new kangRunnable2());
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("나 청소 중");
        }
        System.out.println("나 청소 종료");
    }
}
