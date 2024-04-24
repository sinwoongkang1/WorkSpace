package ch02;

public class ArrayB {
    static void arrayB(int[] array) {
        int min ;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i]>array[j] ) {
                    min = array[i];
                    array[i]=array[j];
                    array[j] = min;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {23,14,2,63,6,54,};
        arrayB(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

