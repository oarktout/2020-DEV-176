package tennis.kata.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tennis.kata.model.TennisGame;

import static org.junit.jupiter.api.Assertions.*;

class TennisGameControllerTest {

    private TennisGameController controller;
    private TennisGame game;

    @BeforeEach
    void initTest(){
        this.controller = new TennisGameController("p1","p2");
        this.game = controller.getGame();
    }

    @Test
    void winAPlayPlayerOneWinAPlay() {
        this.controller.winAPlay(this.game.getPlayerOne(),
                this.game.getPlayerTwo());
        assertEquals(1,this.game.getScorePlayerOne());
        assertEquals(0, this.game.getScorePlayerTwo());
    }

    @Test
    void winAPlayPlayerTwoWinAPlay() {
        this.controller.winAPlay(this.game.getPlayerTwo(),
                this.game.getPlayerOne());
        assertEquals(0, this.game.getScorePlayerOne());
        assertEquals(1, this.game.getScorePlayerTwo());
    }

    @Test
    void winAPlayPlayerOneWinAGame() {
        this.controller.winAPlay(this.game.getPlayerTwo(),
                this.game.getPlayerOne());
        assertEquals(0, this.game.getScorePlayerOne());
        assertEquals(1, this.game.getScorePlayerTwo());
    }

    @Test
    void winAPlayPlayerTwoWinAGame() {
        this.controller.winAPlay(this.game.getPlayerTwo(),
                this.game.getPlayerOne());
        assertEquals(0, this.game.getScorePlayerOne());
        assertEquals(1, this.game.getScorePlayerTwo());
    }

    @Test
    void getScorePlayerOne() {
        assertEquals("love",controller.getScorePlayerOne());
        this.controller.winAPlay(this.game.getPlayerOne(),
                this.game.getPlayerTwo());
        assertEquals("fifteen",controller.getScorePlayerOne());
        this.controller.winAPlay(this.game.getPlayerOne(),
                this.game.getPlayerTwo());
        assertEquals("thirty",controller.getScorePlayerOne());
        this.controller.winAPlay(this.game.getPlayerOne(),
                this.game.getPlayerTwo());
        assertEquals("forty",controller.getScorePlayerOne());
    }

    @Test
    void getScorePlayerTwo() {
        assertEquals("love",controller.getScorePlayerTwo());
        this.controller.winAPlay(this.game.getPlayerTwo(),
                this.game.getPlayerOne());
        assertEquals("fifteen",controller.getScorePlayerTwo());
        this.controller.winAPlay(this.game.getPlayerTwo(),
                this.game.getPlayerOne());
        assertEquals("thirty",controller.getScorePlayerTwo());
        this.controller.winAPlay(this.game.getPlayerTwo(),
                this.game.getPlayerOne());
        assertEquals("forty",controller.getScorePlayerTwo());
    }

    @Test
    void numberOfGamesExpected0() {
        assertEquals(0, controller.numberOfGames());
    }

    @Test
    void numberOfGamesExpected1() {
        //initialize
        for (int i = 0; i <= 3; i++) {
            this.controller.winAPlay(this.game.getPlayerOne(),
                    this.game.getPlayerTwo());
        }

        //check
        assertEquals(1, controller.numberOfGames());
    }

    @Test
    void hasWinnerTrue() {
        //initialize
        while(this.controller.numberOfGames()<=3) {
            this.controller.winAPlay(this.game.getPlayerOne(),this.game.getPlayerTwo());
        }
        //check
        assertTrue(this.controller.hasWinner());

    }

    @Test
    void hasWinnerFalse() {
        //initialize
        while(this.controller.numberOfGames()<3) {
            this.controller.winAPlay(this.game.getPlayerOne(),this.game.getPlayerTwo());
        }
        //check
        assertFalse(this.controller.hasWinner());

    }

    @Test
    void getPlayerOneName() {
        assertEquals("p1",this.controller.getPlayerOneName());
    }

    @Test
    void getPlayerTwoName() {
        assertEquals("p2",this.controller.getPlayerTwoName());
    }
}