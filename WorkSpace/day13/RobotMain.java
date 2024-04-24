package day13;

public class RobotMain {
    public static void main(String[] args) {
        Robot robot = new Robot();
        RobotPlayer playerA = new RobotPlayer("A", robot);
        RobotPlayer playerB = new RobotPlayer("B", robot);
        RobotPlayer playerC = new RobotPlayer("C", robot);

        playerA.start();
        playerB.start();
        playerC.start();

    }
}
