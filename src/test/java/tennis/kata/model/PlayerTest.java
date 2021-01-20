package tennis.kata.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void initializePlayer(){
        player=new Player("Test");
        assertEquals("Test",player.getName());
        assertEquals(0,player.getScore());
        assertEquals(0,player.getScoreGame());
        assertFalse(player.isAdvantage());
    }

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
