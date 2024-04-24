package project.chatServerProject;

import java.util.ArrayList;
import java.util.Scanner;

public class chatOption {

    public static ArrayList<String> makeArrayList (String line) {
        ArrayList<String> wordList = new ArrayList<>();
        String[] words = line.split(" ");
        for (String word : words) {
            wordList.add(word);
        }
        return wordList;
    }
    //공백을 기준으로 단어를 자르고 배열로 저장
    public static ArrayList<String> doNotUserWord(ArrayList<String> arrayList) {
    ArrayList<String> bannedWords = new ArrayList<>();
        bannedWords.add("pizza");
        bannedWords.add("hamburger");
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < bannedWords.size(); j++) {
                if(arrayList.get(i).toLowerCase().equals(bannedWords.get(j))){
                    arrayList.set(i,"*****");
            }
            }
        }
        return arrayList;
    }
// 욕설을 포함한 단어를 검색하여 **** 로 변환

    public static void makeSentence (ArrayList<String> wordList) {
        StringBuilder sentenceBuilder = new StringBuilder();
        for (String word : wordList) {
            sentenceBuilder.append(word).append(" ");
        }
        String sentence = sentenceBuilder.toString().trim();
        System.out.println(sentence);
    }
// **** 이 저장된 배열을 문장으로 전환

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        makeSentence(doNotUserWord(makeArrayList(line)));

    }
    }


