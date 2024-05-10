package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import sample.Dice;
import sample.Game;
import sample.Player;

import java.util.List;
@ComponentScan
@PropertySource({"classpath:game.properties"})
public class GameConfig {
@Bean
    public Dice dice() {
        return new Dice(6);
    }
    @Bean
    public Player son(Dice dice){
    Player player = new Player();
    player.setDice(dice); //dice를 주입하고 있는 코드(설정자방식으로) -> payer가 setter를 가지고 있어야 함.
        player.setName("손흥민");
        return player;
    }
    @Bean
    public Player lee(Dice dice){
        Player player = new Player();
        player.setDice(dice); //dice를 주입하고 있는 코드(설정자방식으로) -> payer가 setter를 가지고 있어야 함.
        player.setName("이강인");
        return player;
    }
    @Bean
    public Player kim(Dice dice){
        Player player = new Player();
        player.setDice(dice); //dice를 주입하고 있는 코드(설정자방식으로) -> payer가 setter를 가지고 있어야 함.
        player.setName("김민재");
        return player;
    }
    @Bean
    public Player hwang(Dice dice){
        Player player = new Player();
        player.setDice(dice); //dice를 주입하고 있는 코드(설정자방식으로) -> payer가 setter를 가지고 있어야 함.
        player.setName("황희찬");
        return player;
    }

    @Bean
    public Game game(List<Player> players){
    return new Game(players); //생성자 방식으로 주입
//   Game game = new Game();
//   game.setList(players);
//   game.play();
//   return game; //설정자 방식으로 주입
    }
}
