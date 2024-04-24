package KIckoff_Project;

import java.util.Scanner;

public class Start {
    public static void start(){
        boolean flag = true;
        boolean flag2 = true;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Player makingPlayer = new Player();
        System.out.println("**** KICK OFF 경기 관리 SYSTEM 에 오신것을 환영합니다 ****");
        while (flag2) {
            System.out.println("************* 원하시는 메뉴를 선택해주세요 **************");
            System.out.println(" 1.선수등록,삭제\t2.경기결과등록,삭제\t3.경기 및 선수조회\t4.프로그램 종료");
            int choice = sc.nextInt();
                if (choice == 1) {
                while (flag) {
                    System.out.println("포메이션을 입력해주세요.");
                    String formation = sc1.nextLine();
                    System.out.println("이름을 입력해주세요");
                    String name = sc2.nextLine();
                    makingPlayer.addPlayer(new Player(formation, name));
                    System.out.println("1.계속 진행하시겠습니까? 2. 종료하시겠습니까?");
                    int select = sc3.nextInt();
                    if (select == 2) {
                        flag = false;
                    }
                }
            }
                if (choice == 2) {
                    System.out.println("기록을 입력하세요, [이름,득점,어시스트,클린]");
                    String name2 = sc1.nextLine();
                    String goal = sc2.nextLine();
                    String assist = sc3.nextLine();
                    String clean = sc4.nextLine();
                    makingPlayer.addStatistics(name2, goal, assist, clean);
            }

                if (choice ==3) {
                    System.out.println("1.개별 선수 조회\t2.전체 선수 조회\t3.이전단계");
                    int choices = sc1.nextInt();
                    if (choices ==1) {
                        System.out.println("찾으시려는 선수의 이름을 입력하세요");
                        Scanner f = new Scanner(System.in);
                        String findName = f.nextLine();
                        makingPlayer.findPlayer(findName);
                    }
                    if (choices ==2) {
                        makingPlayer.displayAllPlayer();
                    }
            }

                if (choice == 4) {
                    System.out.println("프로그램을 종료합니다.");
                    flag2 = false;
                }

        }
    }
}
