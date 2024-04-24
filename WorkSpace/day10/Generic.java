package day10;

public class Generic<T1, T2> {
    private T1 item1;
    private T2 item2;

    public Generic(T1 item1, T2 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }
    public T1 getItem1() {
        return item1;
    }
    public void setItem1(T1 item1) {
        this.item1 = item1;
    }
    public T2 getItem2() {
        return item2;
    }
    public void setItem2(T2 item2) {
        this.item2 = item2;
    }

    public static void main(String[] args) {
        Generic<String,Integer> generic = new Generic("Hello", 10);
        System.out.println(generic.getItem1());
        System.out.println(generic.getItem2());

        Generic<Boolean,String > generic1 = new Generic(true, "why");
        System.out.println(generic1.getItem1());
        System.out.println(generic1.getItem2());
    }
}
