package com.example.asyncfuture;


import com.example.asyncfuture.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class AsyncApplication implements CommandLineRunner {

    @Autowired
    private AsyncService asyncService;
    @Override
    public void run(String...args) throws Exception {
        System.out.println("Async 메서드 호출");
    }

    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);
    }
}
