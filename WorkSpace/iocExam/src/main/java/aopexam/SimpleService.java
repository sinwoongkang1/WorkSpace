package aopexam;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String doSomething() {
        //target
        System.out.println("SimpleService doSomething run");
        return "Doing something";
    }

    public String doNothing() {
        return "Doing nothing";
    }
}
