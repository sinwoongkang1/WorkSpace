package day16;

import java.util.*;

public class Exam {
    public static void main(String[] args) {
        //문제 1: 문자열 리스트 정렬하기
        //요구 사항: 주어진 List<String>을 문자열 길이에 따라 정렬하되, 람다식을 사용하여 Collections.sort() 메서드를 활용하라.
        List<String> array = Arrays.asList("abcd","abc","ab");
        Collections.sort(array,String::compareTo);
        System.out.println(array);
        //문제 2: 최대값 찾기
        //요구 사항: 주어진 정수 배열에서 최대값을 찾아 출력하라. 람다식을 사용하여 자바의 Comparator 인터페이스와 함께 Arrays.sort()를 활용하라.
        Integer[] array1 = {1,2,3,4,5};
        Comparator<Integer> comparator = (a,b) -> b-a;
        Arrays.sort(array1,comparator);
        System.out.println(array1[0]);
        //문제 3: 리스트의 각 요소에 연산 적용하기
        //요구 사항: 주어진 List<Integer>의 각 요소에 10을 더한 결과를 새 리스트에 저장하고 출력하라. 람다식을 사용하여 List의 forEach() 메서드를 활용하라.
        List<Integer> array2 = Arrays.asList(1,2,3,4,5);
        List<Integer> result = new ArrayList<>();
        array2.forEach(n-> result.add(n+10));
        System.out.println(result);
        //문제 4: 조건에 맞는 요소 찾기
        //요구 사항: 주어진 List<String>에서 글자 수가 5 이상인 첫 번째 단어를 찾아 출력하라. for 루프와 람다식을 활용하여 조건에 맞는 요소를 찾아보세요.
        List<String> word = Arrays.asList("a","asdfg","oelekgf");
        for (int i = 0; i < word.size(); i++) {
            if(word.get(i).length()>=5){
                System.out.println(word.get(i));
                break;
            }
        }
        //문제 5: 요소 변환하기
        //요구 사항: 주어진 List<Integer>의 각 요소를 제곱한 결과를 새 리스트에 저장하고 출력하라. for 루프와 람다식을 활용하여 각 요소를 변환하라.
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> result2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
           int a = list.get(i) * list.get(i);
           result2.add(a);
        }
        System.out.println(result2);
        //문제 6: 모든 요소에 대해 조건 확인하기
        //요구 사항: 주어진 List<Integer>의 모든 요소가 짝수인지 확인하라. 람다식을 활용하여 조건 검사를 수행하고 결과를 출력하라.
        List<Integer> array3 = Arrays.asList(1,2,3,4,5);
        List<String> array4 = new ArrayList<>();
        array3.forEach(n-> {
            if (n%2 == 0){
               array4.add("True");
            }else
            {
                array4.add("False");
            }
        });
        System.out.println(array4);
        System.out.println();
    }
}
