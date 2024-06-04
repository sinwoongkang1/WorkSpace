package WorkSpace.WorkSpace.AlgorithmPractice.Programmers;

public class Card {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer ;
        int i = 0;
        int j = 0;

        while (i + j < goal.length) {

            if ( i < cards1.length && goal[i + j].equals(cards1[i]) ) {
                i++;
            }
            else if (j < cards2.length && goal[i + j].equals(cards2[j]) ){
                j++;
            }
            else{
                i = cards1.length+ cards2.length+ goal.length;
            }
        }

            if (i + j == goal.length) {
                answer = "Yes";
            } else{
                answer = "no";
        }
            return answer;
    }

        public static void main (String[]args){
            String[] cards1 = {"i", "drink", "water"};
            String[] cards2 = {"want", "to"};
            String[] goal = {"i", "want", "to", "drink", "water"};

            solution(cards1, cards2, goal);

        }
    }
