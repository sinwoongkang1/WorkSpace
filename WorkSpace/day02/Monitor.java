package ch02;

public class Monitor {
    int size ;
    String pixel ;
    double weight;

    Monitor (int size, String pixel, double weight) {
        this.size = size;
        this.pixel = pixel;
        this.weight = weight;
    }

    void on() {
        System.out.println("화면이 켜졌습니다");
    }
    void out() {
        System.out.println("화면이 꺼졌습니다.");
    }

    void connect(){
        System.out.println("입력을 확인하세요");

    }
    void info(){
        System.out.println("모니터의 크기 "+size +"인치");
        System.out.println("모니터의 화질 "+pixel);
        System.out.println("모니터의 무게 "+weight + "kg");
    }
}
