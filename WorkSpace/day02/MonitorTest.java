package ch02;

public class MonitorTest {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(21,"FHD",3.2);
        Monitor monitor1 = new Monitor(27,"UHD",4.1);
        Monitor monitor2 = new Monitor(32,"8K",5.0);

        monitor2.info();



    }
}
