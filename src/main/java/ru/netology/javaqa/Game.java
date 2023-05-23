package ru.netology.javaqa;

// import java.util.ArrayList;
import java.util.HashMap;
// import java.util.List;

public class Game {

    private HashMap<String, Player> playerHashMap;


    public Game() {
        playerHashMap = new HashMap<>();
    }

    public void register(Player player) {
        playerHashMap.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = playerHashMap.get(playerName1);
        Player player2 = playerHashMap.get(playerName2);


        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Один или оба игрока не зарегестрированы.");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
//  метод в варианте с HashMap не нужен, доступ к игроку через метод get() в playerHashMap
//    private Player findPlayerByName(String name) {
//        for (Player player : players) {
//            if (player.getName().equals(name)) {
//                return player;
//            }
//        }
//        return null;
//    }
}
