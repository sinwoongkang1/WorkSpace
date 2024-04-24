package ch02;

public class Search {

    static void search(int[] array, int a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                System.out.println(i + "번째에 데이터가 존재합니다");
                break;
            } else {
            }
        }
    }
        public static void main (String[] args){
            int[] data = {1, 466, 2, 5, 2345, 4, 22};
            search(data, 5);
        }
    }
