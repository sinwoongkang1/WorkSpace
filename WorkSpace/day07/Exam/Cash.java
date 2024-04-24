package day07.Exam;

public class Cash implements Payment{
    @Override
    public void processPayment() {
        System.out.println("현금으로 결제합니다");
    }
}
