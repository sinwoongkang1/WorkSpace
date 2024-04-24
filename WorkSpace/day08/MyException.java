package day08;

public class MyException extends RuntimeException {
    public MyException() {
        super("Please Input number Over 0, Under 100");
    }
    public MyException(String message) {
        super(message);
    }
}
