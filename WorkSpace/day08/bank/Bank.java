package day08.bank;

import java.util.Random;

public class Bank {
    String name = "멋사은행";
    int[] accountArray = {};





    public static void main(String[] args) throws bankException {
        Account account = new Account(1000,"kang");
        Banker banker = new Banker();
        banker.makeAccount();
        account.toString();


    }
}
