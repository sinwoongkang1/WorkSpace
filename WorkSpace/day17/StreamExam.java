package day17;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a","b","c","d","e");
        List<String> filteredList = myList.stream()
                                          .filter(p->p.startsWith("b"))
                                          .collect(Collectors.toList());
        System.out.println(filteredList);

        String[] names = {"kang","king","hong","lee","son"};
        Arrays.stream(names).forEach(System.out::println);
        Arrays.stream(names).forEach(s-> System.out.println(s));
        Arrays.stream(names).filter(s->s.startsWith("k")).forEach(System.out::println);


        int[] iarr = {1,2,3,4,5,6,7,8};
        Arrays.stream(iarr).filter(a->a%2!=0).forEach(System.out::println);

        List<String> words = Arrays.asList("apple","banana","cherry","date","pineapple");
        List<String> uniqueFruits = words.stream().filter(f->f.length()>=5)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueFruits);
        List<String> uniqueFruits2 = words.stream().filter(a->a.length()>=5).map(a->a.toUpperCase()).distinct().collect(Collectors.toList());
        System.out.println(uniqueFruits2);

        int[] intArr = {3,6,3,76,4,2};
        Arrays.stream(intArr).map(num -> num*3).forEach(System.out::println);
        System.out.println("==========");
        Arrays.stream(intArr).sequential().filter(num->num%2==0).map(num->num*3).forEach(System.out::println);

        System.out.println("================");
        List<List<String>> nestedList = Arrays.asList(Arrays.asList("a","b"),Arrays.asList("c","d"));
        System.out.println(nestedList);
        List<String> a = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(a);

        List<String> mixFruits = Arrays.asList("banana","apple","date","pineapple","cherry");
        List<String>sortedFruits = mixFruits.stream()
                .sorted()
                .toList();
        List<String>reverseSortedFruits = mixFruits.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedFruits);
        System.out.println(reverseSortedFruits);

        System.out.println("====================================");

        int[] array = {5,3,27,9,5,9,0,4,34};
        //오름차순 정렬 출력
        Arrays.stream(array).sorted().forEach(System.out::print);
        //내림차순 정렬 출력
        Arrays.stream(array).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
