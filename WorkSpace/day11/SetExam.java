package day11;

import java.util.HashSet;
import java.util.Set;

public class SetExam {
    public static void main(String[] args) {
    Set<String> abc = new HashSet<String>();
    abc.add("A");
    abc.add("B");
    abc.add("C");
    System.out.println(abc);

    Set<Pen> penset = new HashSet<>();
    penset.add(new Pen("red"));
    penset.add(new Pen("green"));
    penset.add(new Pen("blue"));

    System.out.println(penset);
    penset.add(new Pen("red"));
    System.out.println(penset);



    }
}
