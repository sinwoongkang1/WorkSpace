package day08.bank;

import java.util.Random;

//통장 객체
public class Account {
    private int balance = 1;
    private String customerName;

    //원하는 금액 입금하고,계좌번호,고객이름 으로 객체 생성
    public Account(int balance, String customerName) {
        this.balance = balance;
        this.customerName = customerName;


    }
    //초기 금액 1원,계좌번호,고객이름으로 생성
    public Account(String customerName) {
        this.customerName = customerName;
    }


    //통장에서 출금 (잔액이 부족할 경우 예외 발생)
    public void withdraw(int money) throws bankException {
        int bal = balance - money;
        if (bal < 0) {
            throw new bankException("잔액이 부족합니다");
        }
        System.out.println("출금하신 금액은 "+money+" 원 입니다");
        System.out.println("통장 잔액은 " + bal + " 원 입니다");
    }
    //통장에 입금
    public void deposit(int money) {
        int bal = balance + money;
        System.out.println("입금하신 금액은 "+money+" 원 입니다");
        System.out.println("통장 잔액은 " + bal + " 원 입니다");
    }
}
