package day10;

public class Pair <K,V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }

    public static <A> void printArray(A[] array) {
        for (A a : array) {
            System.out.print(a+" ");
        }
    }

    public static <T extends Number> T maxValue (T a, T b,T c) {
        T max = a;
        if (b.doubleValue() > max.doubleValue()) {
            max = b;
        }
        if (c.doubleValue() > max.doubleValue()) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String, Integer>("Age", 35);
        String key = pair.getKey();
        int value = pair.getValue();
        System.out.println("Key: " + key+" Value: " + value);

        Integer[] array = {1,2,3,4,5,6,7,8,9};
        String[] array2 = {"Oh","My","God","It's","Monday"};

        printArray(array2);
        System.out.println();
        printArray(array);
        System.out.println();
        System.out.println("======================");
        System.out.println(maxValue(10,45,1));
    }
}
