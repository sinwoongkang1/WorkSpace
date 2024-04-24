package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");
        fruits.add("포도");

        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        Vector<String> animals = new Vector<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("bird");
        animals.add("flower");

        System.out.println(animals);
        animals.set(3, "lion");
        animals.remove(2);
        System.out.println(animals);


    }
}
