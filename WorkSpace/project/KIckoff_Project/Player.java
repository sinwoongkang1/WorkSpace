package KIckoff_Project;

import java.util.*;

public class Player {
    String formation ;
    String name;
    int goal;
    int assist;
    int clean;
    public Player() {
    }

    public Player(String formation, String name) {
        this.formation = formation;
        this.name = name;

    }
    Set<Player> playerList = new HashSet<>() {
    };
    public void addPlayer (Player player) {
        playerList.add(player);
//        System.out.println(playerList);
    }

    Map <String, String> playerGoals = new HashMap<>();
    Map <String, String> playerAssists = new HashMap<>();
    Map <String, String> playerClean = new HashMap<>();
    public void addStatistics(String name,String goal,String assist, String clean) {
       playerGoals.put(name,goal);
       playerAssists.put(name,assist);
       playerClean.put(name,clean);

    }
    public void findPlayer(String name) {
     for(Player player : playerList) {
         if (player.getName().equals(name)){
             System.out.println(player+
                     " 득점 : "+playerGoals.get(name)+
                     " 어시스트 : "+playerAssists.get(name)+
                     " 클린 : "+playerClean.get(name));

         }
     }
}
    public void displayAllPlayer(){
        for(Player player : playerList) {
            System.out.println(
            "이름 : "+player.getName()+"\t"+
            "포메이션 : "+player.getFormation()+"\t"+
            "득점 : "+playerGoals.get(player.getName())+"\t"+
            "어시스트: "+playerAssists.get(player.getName())+"\t"+
            "클린: "+playerClean.get(player.getName())
            );

        }
    }

    public String getName() {
        return this.name;
    }
    public String getFormation() {
        return formation;
    }
    @Override
    public String toString() {
        return "["+this.formation + ", " + this.name+"]" ;
    }
}
