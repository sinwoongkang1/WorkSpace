package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleExam {
    public static void main(String[] args) {
        ArrayList<Integer> arrray = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            arrray.add(i);
        }
        System.out.println("원래 순서");
        System.out.println(arrray);
        Collections.shuffle(arrray);
        System.out.println("나중 순서");
        System.out.println(arrray);

        List<String>list = new ArrayList<>();
        list.add("kang");
        list.add("kim");
        list.add("hong");
        list.add("lee");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
