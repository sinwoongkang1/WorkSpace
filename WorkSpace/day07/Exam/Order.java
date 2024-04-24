package day07.Exam;

public abstract class Order {

    public void takeOrder() {
        System.out.println("주문을 받겠습니다.");
    }
    public void takeMoney() {
        System.out.println("결제를 하겠습니다");
    }

    public abstract void serveFood();

    public abstract void preparedFood();

    public final void complementOrder(){
      takeOrder();
      preparedFood();
      serveFood();
      System.out.println("주문이 완료되었습니다.");
    };
}
