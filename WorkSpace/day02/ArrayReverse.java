package ch02;

public class ArrayReverse {
    static void arrayReverse(int[] array) {
        int space ;
        for (int i = 0; i < array.length/2; i++) {
            space = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = space;
        }
    }

    public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
    arrayReverse(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);

        }
    }
}
