package day07.Exam;

public class Run implements Payment{
    @Override
    public void processPayment() {
        System.out.println("손님이 도망갑니다.");
    }
}
