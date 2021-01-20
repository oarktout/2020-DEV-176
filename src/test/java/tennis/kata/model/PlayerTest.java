package tennis.kata.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Player player;

    @Test
    void wonAGame() {

        player.wonAGame();

        assertEquals(1,player.getScoreGame());
    }

    @Test
    void wonAPoint() {

        player.wonAPoint();

        assertEquals(1,player.getScore());
    }
}
