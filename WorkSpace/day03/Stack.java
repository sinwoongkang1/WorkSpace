package ch03;

public class Stack {

    public static void push (int[] array, int a) {
        array[array.length-1] = array[a] ;
    }

    public static int pop (int[] array, int a) {
        int space;
        space = array[array.length-1];
        array[array.length-1] = 0;
        return space ;
    }

    public static int top (int[] array, int a){
        return array[array.length-1];
    }

    public static boolean isEmpty (int[] array, int a) {
        if(array[array.length-1]==0) {
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i ;
        }

    }
}
