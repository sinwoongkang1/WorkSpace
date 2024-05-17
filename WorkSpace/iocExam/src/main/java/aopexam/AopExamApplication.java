package aopexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopExamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AopExamApplication.class, args);
    }

    @Autowired
    SimpleService simpleService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(simpleService.doSomething());
        System.out.println(simpleService.doNothing());
    }

}
