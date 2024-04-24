package ch02;

public class Woe {
    public static void main(String[] args) {
//        int[][] scores = new int [3][4];
//        scores[0][0]=90;
//        scores[0][1]=80;
//        scores[0][2]=70;
//        scores[0][3]=60;
//
//        scores[1][0]=80;
//        scores[1][1]=70;
//        scores[1][2]=60;
//        scores[1][3]=50;
//
//        scores[2][0]=70;
//        scores[2][1]=60;
//        scores[2][2]=50;
//        scores[2][3]=40;

        int[][] scores = {
                {90, 80, 70, 60},
                {80, 70, 60, 50},
                {70, 60, 50, 40},
        };

        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + 1 + "번째 학생 과목 점수");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println(scores[i][j]);
            }
        }
        System.out.println();


//        for (int i = 0; i < scores.length; i++) {
//            System.out.println(i + 1 + "번째 학생의 점수 총 합");
//            int sum = 0;
//            for (int j = 0; j < scores[i].length; j++) {
//                sum = sum + scores[i][j];
//            }
//            System.out.println(sum);

            for (int k = 0; k < scores.length; k++) {
                System.out.println(k + 1 + "번째 학생의 점수 평균");
                int ave = 0;
                for (int t = 0; t < scores[k].length; t++) {
                    ave = ave + scores[k][t];
                }
                System.out.println(ave / scores[k].length);


            }
        }
    }
