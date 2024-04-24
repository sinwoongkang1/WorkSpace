package day13;
class incrementThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try{
                Thread.sleep(5);
                System.out.println("Increment :" +" { "+i+" }");
            }catch(RuntimeException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class decrementThread implements Runnable {
    @Override
    public void run() {
        for (int i = 100; i >= 1; i--) {
            try{
                Thread.sleep(10);
                System.out.println("Decrement :" +" { "+i+" }");
            }catch(RuntimeException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class CounterApp {
    public static void main(String[] args) {
      Thread incrementThread = new Thread(new incrementThread());
      Thread decrementThread = new Thread(new decrementThread());
      incrementThread.start();
      decrementThread.start();
    }
}
