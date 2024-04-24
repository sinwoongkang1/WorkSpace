package day07.Exam;

public class BurgerOrder extends Order{
    @Override
    public void serveFood() {
        System.out.println("햄버거를 서빙합니다");
    }

    @Override
    public void preparedFood() {
        System.out.println("햄버거를 준비합니다.");
    }
}
