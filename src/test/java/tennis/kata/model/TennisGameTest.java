package tennis.kata.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisGameTest {

    private TennisGame tennisGame;
    private Player playerOne;
    private Player playerTwo;

    @Test
    void whoWinnerPlayerOne() {
        //initialize test
        for(int i=0;i<=3;i++){
            playerOne.wonAGame();
        }

        //check
        assertEquals(playerOne,tennisGame.whoWinner());
    }

    @Test
    void whoWinnerPlayerTwo() {
        //initialize test
        for(int i=0;i<=3;i++){
            playerTwo.wonAGame();
        }
        tennisGame=new TennisGame(playerOne, playerTwo);
        //check
        assertEquals(playerTwo,tennisGame.whoWinner());


    }

    @Test
    void whoWinnerNobody() {

        assertNull(tennisGame.whoWinner());
    }


    @Test
    void isDeuceTrue() {

        for(int i=0;i<=3;i++) {
            playerOne.wonAGame();
            playerTwo.wonAGame();
        }

        assertTrue(tennisGame.isDeuce());
    }

    @Test
    void isDeuceFalse() {
        assertFalse(tennisGame.isDeuce());
    }

    @Test
    void getScorePlayerOne() {

        assertEquals(0,tennisGame.getScorePlayerOne());
        playerOne.wonAPoint();
        assertEquals(1,tennisGame.getScorePlayerOne());
        playerOne.wonAPoint();
        assertEquals(2,tennisGame.getScorePlayerOne());
        playerOne.wonAPoint();
        assertEquals(3,tennisGame.getScorePlayerOne());
    }

    @Test
    void getScoreNamePlayerTwo() {

        assertEquals(0,tennisGame.getScorePlayerTwo());
        playerTwo.wonAPoint();
        assertEquals(1,tennisGame.getScorePlayerTwo());
        playerTwo.wonAPoint();
        assertEquals(2,tennisGame.getScorePlayerTwo());
        playerTwo.wonAPoint();
        assertEquals(3,tennisGame.getScorePlayerTwo());
    }
}