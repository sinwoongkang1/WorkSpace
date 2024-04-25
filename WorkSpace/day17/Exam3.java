package day17;

import java.util.Arrays;
import java.util.List;

public class Exam3 {
    public static void main(String[] args) {
        System.out.println("====================");
        System.out.println("실습 문제 6: 나이대별 평균 점수 계산");
        List<Child> students = Arrays.asList(
                new Child("Alice", 14, 88),
                new Child("Bob", 23, 82),
                new Child("Charlie", 17, 95),
                new Child("David", 21, 73)
        );
    double ageTeens = students.stream().filter(age->age.getAge()>=10&&age.getAge()<20).
            mapToDouble(Child::getScore).
            average().
            orElse(0.0);
    double ageTwenty = students.stream().filter(age->age.getAge()>=20).
            mapToDouble(Child::getScore).
            average().
            orElse(0.0);
        System.out.println("10's : "+ageTeens);
        System.out.println("20's : "+ageTwenty);

        System.out.println("====================");
        System.out.println("실습 문제 7: 도시별 최고 온도 기록");

        List<Temperature> temperatures = Arrays.asList(
                new Temperature("Seoul", 33),
                new Temperature("New York", 30),
                new Temperature("Seoul", 34),
                new Temperature("New York", 28)
        );
        int seoulMaxTemp = temperatures.stream().filter(city->city.getCity().equals("Seoul")).
                mapToInt(Temperature::getMaxTemp).
                max().
                orElse(0);
        int newyorkMaxTemp = temperatures.stream().filter(city->city.getCity().equals("New York")).
                mapToInt(Temperature::getMaxTemp).
                max().
                orElse(0);
        System.out.println("Seoul : "+ seoulMaxTemp);
        System.out.println("New york : "+newyorkMaxTemp);
    }
}
class Child {
    private String name;
    private int age;
    private int score;

    public Child(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}
class Temperature {
    private String city;
    private int maxTemp;

    public Temperature(String city, int maxTemp) {
        this.city = city;
        this.maxTemp = maxTemp;
    }

    public String getCity() {
        return city;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}