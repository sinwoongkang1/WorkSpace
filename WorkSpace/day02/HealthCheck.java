package ch02;
import java.util.Scanner;
//public class HealthCheck {
//    static final int PMAX = 16;
//
//    static class HealthData {
//String name;
//int weight;
//double bloodPressure;
//
//HealthData (String name, int weigh, double bloodPressure) {
//    this.name = name;
//    this.weight = weigh;
//    this.bloodPressure = bloodPressure;
//    }
//    static double aveWeight(HealthData[] dat){
//
//    }
//
//}
//
//    }
//        public static void main(String[] args) {
//            Scanner stdIn = new Scanner(System.in);
//
//            HealthData[] x = {
//                    new HealthData("홍길동", 74, 128.0),
//                    new HealthData("이순신", 85, 115.0),
//                    new HealthData("장보고", 95, 99.0),
//                    new HealthData("유관순", 65, 102.0),
//                    new HealthData("김구", 78, 120.0),
//                    new HealthData("안중근", 88, 130.0),
//                    new HealthData("박문수", 77, 140.0),
//            };
//            int[] bpdist = new int[PMAX]; // 혈압의 분포
//
//            System.out.println("■ 건강검진 리스트 ■");
//            System.out.println(" 이름    체중 혈압");
//            System.out.println("--------------------");
//            for (int i = 0; i < x.length; i++)
//                System.out.printf("%-6s%3d%5.1f\n",
//                        x[i].name, x[i].weight, x[i].bloodPressure);
//
//            System.out.printf("\n평균 체중: %5.1fkg\n", aveWeight(x));
//
//            distBloodPressure(x, bpdist); // 혈압의 분포를 구함
//
//            System.out.println("\n혈압 분포");
//            for (int i = 0; i < PMAX; i++)
//                System.out.printf("%3.1f～: %2d명\n", (i + 6) * 10.0, bpdist[i]);
//        }
//    }
