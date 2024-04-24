package ch03;

public class Choice {

        static void coice(int[] array) {
            int space;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i] < array[j]) {
                        space = array[i];
                        array[i] = array[j];
                        array[j] = space;
                    }

                }
            }
        }

        public static void main(String[] args) {
            int[] array = {64, 33, 67, 22, 6, 88, 5};
            coice(array);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
            }
        }
    }