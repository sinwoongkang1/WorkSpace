package day07.Exam;

public class FoodOrderSystem {
    public static void main(String[] args) {
        PizzaOrder pizzaOrder = new PizzaOrder();
        BurgerOrder burgerOrder = new BurgerOrder();
        Payment apayment = new CreditPayment();
        Payment bpayment = new Cash();
        Run run = new Run();
        pizzaOrder.complementOrder();
        apayment.processPayment();
        System.out.println("==================");
        burgerOrder.complementOrder();
        bpayment.processPayment();
        System.out.println("==================");
        burgerOrder.complementOrder();
        run.processPayment();
    }
}
