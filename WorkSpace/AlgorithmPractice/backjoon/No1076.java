package WorkSpace.WorkSpace.AlgorithmPractice.backjoon;

import java.util.Scanner;

public class No1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();

        Long a = trans(str1)*10;
        Long b = trans(str2);
        Long c = (long) Math.pow(10,trans(str3));

        System.out.println((a+b)*c);

    }
    public static Long trans (String str) {
        if (str.equals("black")){
            return 0L;
        } else if (str.equals("brown")){
            return 1L;
        } else if (str.equals("red")){
            return 2L;
        } else if (str.equals("orange")){
            return 3L;
        } else if (str.equals("yellow")){
            return 4L;
        }else if (str.equals("green")){
            return 5L;
        } else if (str.equals("blue")){
            return 6L;
        }else if (str.equals("violet")){
            return 7L;
        }else if (str.equals("grey")){
            return 8L;
        }else if (str.equals("white")){
            return 9L;
        }else
            return 0L;
    }
}
