package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Persion implements Comparable<Persion> {
    @Override
    public int compareTo(Persion o) {
        return this.name.compareTo(o.name);
    }
    String name;
    int age;

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : "+ age ;
    }

    public static void main(String[] args) {
        List<Persion> persions = new ArrayList<Persion>();
        persions.add(new Persion("Bob", 18));
        persions.add(new Persion("John", 22));
        persions.add(new Persion("POOW", 24));
        persions.add(new Persion("Amanda", 77));

        Collections.sort(persions, new Comparator<Persion>() {

            @Override
            public int compare(Persion o1, Persion o2) {
                return o1.age - o2.age;
            }
        });

        System.out.println(persions);
        Collections.sort(persions);
        System.out.println(persions);
    }
}
