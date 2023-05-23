package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void shouldWinPlayer1Test() {
        Player player1 = new Player(1, "Джеймс Бонд", 100);
        Player player2 = new Player(2, "Итан Хант", 50);
        game.register(player1);
        game.register(player2);

        int result = game.round("Джеймс Бонд", "Итан Хант");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldWinPlayer2Test() {
        Player player1 = new Player(1, "Джеймс Бонд", 50);
        Player player2 = new Player(2, "Итан Хант", 100);
        game.register(player1);
        game.register(player2);

        int result = game.round("Джеймс Бонд", "Итан Хант");
        Assertions.assertEquals(2, result);

    }

    @Test
    void shouldBeDrawTest(){
        Player player1 = new Player(1, "Джеймс Бонд", 50);
        Player player2 = new Player(2, "Итан Хант", 50);
        game.register(player1);
        game.register(player2);

        int result = game.round("Джеймс Бонд", "Итан Хант");

        Assertions.assertEquals(0,result);
    }
    @Test
    void gameWithNotRegisterPlayer1Test(){
        Player player1 = new Player(1, "Джеймс Бонд", 50);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Джеймс Бонд", "Итан Хант"));
    }
    @Test
    void gameWithNotRegisterPlayer2Test(){
        Player player2 = new Player(2, "Итан Хант", 50);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Джеймс Бонд", "Итан Хант"));
    }

    @Test
    void gameBothNotRegisterPlayersTest(){
        Player player1 = new Player(1, "Джеймс Бонд", 50);
        Player player2 = new Player(2, "Итан Хант", 50);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Джеймс Бонд", "Итан Хант"));
    }
}
