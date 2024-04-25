package day17;

public class Member {
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    private String name;
    private int score;
    private int age;
    private int sex;

    public Member(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Member(String name, int sex,int age) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
