package day16;

public class RamdaExam3 {
    public static void main(String[] args) {
        //인터페이스에서 함수를 오버로딩
        MyFunction myFunction;
        myFunction = new MyFunction() {
            @Override
            public void method1(int x, int y) {
                int result = x * y ;
                System.out.println(result);
            }
        };
            myFunction.method1(5,10);

            //람다식으로 오버로딩
        myFunction = (x,y) -> {
            int result = x + y;
        System.out.println(result);
        };
            myFunction.method1(5,10);
    }
}
