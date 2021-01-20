package tennis.kata.model;

public class TennisGame {
    private final Player playerOne;
    private final Player playerTwo;

    public TennisGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player whoWinner(){
        if(playerOne.getScoreGame() >= 4 && playerOne.getScoreGame() >= playerTwo.getScoreGame() + 2 ){
            return playerOne;
        }else{
            if(playerTwo.getScoreGame() >= 4 && playerTwo.getScoreGame() >= playerOne.getScoreGame() + 2 ){
                return playerTwo;
            }else{
                return null;
            }
        }

    }

    public boolean isDeuce(){

        return playerOne.getScoreGame() >= 3 && playerTwo.getScoreGame() == playerOne.getScoreGame();
    }

    public int getScorePlayerOne(){
        return playerOne.getScore();
    }

    public int getScorePlayerTwo(){
        return playerTwo.getScore();
    }

}