package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Exam {
    public static void main(String[] args) {
        // 1. 반복문을 이용한 풀이
        System.out.println("실습 문제 1: 숫자 배열 처리");
        int[] numbers = {3, 10, 4, 17, 6};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2==0){
                sum = sum + numbers[i];
            }
        }
        System.out.println(sum);
        // 2. 스트림과 람다를 이용한 풀이
        int sum1 = Arrays.stream(numbers).filter(n->n%2==0).sum();
        System.out.println(sum1);

        System.out.println("====================");
        System.out.println("실습 문제 2: 문자열 리스트 필터링");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        //1. 반복문과 조건문을 이용한 풀이
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length()>=5) {
                result.add(words.get(i).toUpperCase());
            }
        }
        System.out.println(result);
        //2.스트림과 람다를 이용한 풀이
        List<String> result2 = words.stream().filter(word->word.length()>=5).map(String::toUpperCase).toList();
        System.out.println(result2);

        System.out.println("====================");
        System.out.println("실습 문제 3: 학생 성적 처리");
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );
        //1.반복문과 조건문을 이용한 풀이
        List<String> studentsName = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getScore()>80){
                studentsName.add(students.get(i).getName());
            }
        }
        Collections.sort(studentsName);
        System.out.println(studentsName);
//        2.스트림과 람다를 이용한 풀이
        List<String> studentsName2 = students.stream().filter(s->s.getScore()>80).map(s->s.getName()).sorted().toList();

        System.out.println(studentsName2);

        System.out.println("====================");
        System.out.println("실습 문제 4: 직원 관리");
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );
        double sum2 = 0;
        double sum3 = 0;
        int hrPeople = 0;
        int engineeringPeople = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment()=="HR"){
                sum2 = (sum2 + employees.get(i).getSalary());
                hrPeople ++;
            }
            if (employees.get(i).getDepartment()=="Engineering"){
                sum3 = (sum3 + employees.get(i).getSalary());
                engineeringPeople ++;
            }
        }
        System.out.println("HR : "+ sum2/hrPeople);
        System.out.println("Engineering : "+ sum3/engineeringPeople);
        //2.스트림과 람다를 이용한 풀이.
        double hrSalary = employees.stream().
                filter(depart-> depart.getDepartment().equals("HR")).
                mapToDouble(Employee::getSalary).
                average().
                orElse(0.0);

        double engSalary = employees.stream().
                filter(e-> e.getDepartment().equals("Engineering")).
                mapToDouble(Employee::getSalary).
                average().
                orElse(0.0);
        System.out.println("HR : " + hrSalary);
        System.out.println("Engineering : " + engSalary );
    }
}
class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}