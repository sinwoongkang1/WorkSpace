package com.example.asyncfuture.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {
    @Async
    public Future<String> asyncMethod1() throws InterruptedException {
        System.out.println("asyncMethod1 시작!");
        Thread.sleep(2000);
        System.out.println("asyncMethod1 종료!");
        return new AsyncResult<>("asyncMethod1 결과값입니다.");

    }@Async
    public Future<String> asyncMethod2() throws InterruptedException {
        System.out.println("asyncMethod2 시작!");
        Thread.sleep(3000);
        System.out.println("asyncMethod2 종료!");
        return new AsyncResult<>("asyncMethod2 결과값입니다.");
    }
}
