package sample;

import org.springframework.stereotype.Component;


public class MyBean {
    private String name;
    private int count;

    public MyBean() {
        System.out.println("MyBean 생성!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
