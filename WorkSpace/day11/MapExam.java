package day11;

import java.util.HashMap;
import java.util.Map;

public class MapExam {
    public static void main(String[] args) {
    Map<String, String> phoneBook = new HashMap<>();

    phoneBook.put("손흥민", "010-3233-5325");
    phoneBook.put("이강인", "010-6743-0830");
    phoneBook.put("김민재", "010-7492-9929");

    String sonNumber = phoneBook.get("손흥민");
        System.out.println("손흥민의 전화번호 : "+sonNumber);

        phoneBook.remove("김민재");

    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    if(phoneBook.containsKey("이강인")) {
        System.out.println("있어요");
    }else {
        System.out.println("없어요");
    }
    if(phoneBook.containsValue("010-4332-4001")){
        System.out.println("있어요");
    }else{
        System.out.println("없어요");
    }
        System.out.println("전화번호부는 비었는가?"+phoneBook.isEmpty());
        System.out.println("전화번호부 크기"+phoneBook.size());

    }


}

