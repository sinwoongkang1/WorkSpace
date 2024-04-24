package day07.Exam;

public class CreditPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("신용카드로 결제합니다");
    }
}
