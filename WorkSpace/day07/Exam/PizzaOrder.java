package day07.Exam;

public class PizzaOrder extends Order{

    @Override
    public void serveFood() {
        System.out.println("피자를 서빙합니다");
    }

    @Override
    public void preparedFood() {
        System.out.println("피자를 준비합니다");
    }
}
