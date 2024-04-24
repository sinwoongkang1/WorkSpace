package WorkSpace.WorkSpace.AlgorithmPractice;

public class Taxi {
public static int taxiFee(int time, int km) {
    int totalFee= 0;

    final int FEE = 410;
    final int TIMES = 600;
    final int DIS = 8;

    if (time<600) {
        time = 600;
    }
    if (km <8) {
        km = 8;
    }

    totalFee = FEE +((time-TIMES)*2) + ((km-DIS)*210);
    return totalFee;
}


    public static void main(String[] args) {
    int fee = taxiFee(1000,10);
        System.out.println("최종 요금은 : "+fee);
    }
}
