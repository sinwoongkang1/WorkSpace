package ch02;

public class CompareArrray {

    static boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i]!=array2[i]) {
                return false;
            }
        } return true;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 4};

        boolean a = compareArrays(array1,array2);
        boolean b = compareArrays(array2,array3);
        System.out.println("배열1과 배열2는 동일한가 : "+a);
        System.out.println("배열2와 배열3은 동일한가 : "+b);


    }
}
