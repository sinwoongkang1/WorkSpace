package day08.bank;

import java.util.Random;

public class Banker {
    String name = "은행원" ;
    int[] id = {1,2,3,4,5,6,7,8,9} ;

    public void makeAccount(){
        String accountCode;
        Random random = new Random();
        String[] letter = {"AB", "CD", "EF"};
        int r = random.nextInt(letter.length);
        int a = random.nextInt(8999)+1000;
        accountCode = letter[r];
        System.out.println(accountCode+a);
    }
}
