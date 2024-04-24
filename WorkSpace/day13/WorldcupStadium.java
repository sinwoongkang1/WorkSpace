package day13;
class Gate {
    public static final Object lock = new Object();
    public static final boolean enter = false;
    class EastGate extends Thread {
        public void run() {
            synchronized (lock) {
                System.out.println("동문 입장 시작");
                    try {
                        lock.wait();
                        for (int i = 1; i <= 10; i++) {
                            Thread.sleep(500);
                        System.out.println("동문 " + i + " 번째 일반손님 입장 중");

                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }lock.notifyAll();

            }
            System.out.println("동문 입장 완료");
            System.out.println("동문 입구 폐쇠");
        }
    }
    class EastVipGate extends Thread {
        public void run() {
            synchronized (lock) {
                System.out.println("동문 VIP 입장 시작");
                for (int i = 1; i <= 10; i++) {
                    System.out.println("동문 " + i + " 번째 VIP 손님 입장 중");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }lock.notifyAll();
            }
            System.out.println("동문 VIP 입장 완료");
            System.out.println("동문 VIP 입구 폐쇠");
        }
    }
    class southGate extends Thread {
        public synchronized void run() {
            synchronized (lock) {
                System.out.println("남문 입장 시작");
                    try {
                        lock.wait();
                        for (int i = 1; i <= 10; i++) {
                            Thread.sleep(500);
                            System.out.println("남문 " + i + " 번째 일반손님 입장 중");

                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }lock.notifyAll();

            }
            System.out.println("남문 입장 완료");
            System.out.println("남문 입구 폐쇠");
        }
    }
    class WestGate extends Thread {
        public void run() {
            synchronized (lock) {
                System.out.println("서문 입장 시작");
                    try {
                        lock.wait();
                        for (int i = 1; i <= 10; i++) {
                            System.out.println("서문 " + i + " 번째 일반손님 입장 중");

                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }lock.notifyAll();

            }
            System.out.println("서문 입장 완료");
            System.out.println("서문 입구 폐쇠");
        }
    }
}
public class WorldcupStadium {
    public static void main(String[] args) {
        System.out.println("월드컵 경기장 입장을 시작합니다");
        Thread t1 = new Gate().new EastGate();
        Thread t2 = new Gate().new EastVipGate();
        Thread t3 = new Gate().new WestGate();
        Thread t4 = new Gate().new southGate();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
          t1.join();
          t2.join();
          t3.join();
          t4.join();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("경기가 시작되었습니다.");
    }
}

