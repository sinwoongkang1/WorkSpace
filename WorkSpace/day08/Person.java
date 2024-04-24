package day08;
public class Person {
    private final int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


        public static void main(String[] args) {
            Person person = new Person(1001, "John Doe");
            System.out.println("사람의 ID: " + person.getId());
            System.out.println("사람의 이름: " + person.getName());

            person.setName("Jane Doe");
            System.out.println("변경된 이름: " + person.getName());
        }

}




