package tennis.kata.controller;

import tennis.kata.model.Player;
import tennis.kata.model.TennisGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TennisGameController {

    private final TennisGame game;
    private final Map<Integer,String> translateScore=new HashMap<>();

    public TennisGameController(String firstPlayerName, String secondPlayerName) {
        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);
        this.game = new TennisGame(firstPlayer,secondPlayer);
        translateScore.put(0,"love");
        translateScore.put(1,"fifteen");
        translateScore.put(2,"thirty");
        translateScore.put(3,"forty");
    }

    public String winAPlay(Player playerWonPoint,Player otherPlayer){
        playerWonPoint.wonAPoint();

        if(playerWonPoint.getScore()>3){
            playerWonPoint.wonAGame();
            if(this.hasWinner()){
                return this.game.whoWinner().getName()+ " is the winner";
            }
            if(this.game.isDeuce()){
                if(playerWonPoint.isAdvantage()){
                    return playerWonPoint.getName()+" won a game, Next Game !";
                }else{
                    playerWonPoint.setAdvantage(true);
                    otherPlayer.setAdvantage(false);
                    return "Advantage for: "+playerWonPoint.getName();
                }

            }else{
                this.game.initializeANewGame();
                return playerWonPoint.getName()+" won a game, Next Game !";
            }
        }else{
            return playerWonPoint.getName() + " won a point ,Next Ball ! ";
        }
    }

    public String getScorePlayerOne(){
        return translateScore.get(this.game.getScorePlayerOne());
    }


    public String getScorePlayerTwo(){
        return translateScore.get(this.game.getScorePlayerTwo());
    }

    public String getPlayerOneName(){
        return this.game.getPlayerOne().getName();
    }

    public String getPlayerTwoName(){
        return this.game.getPlayerTwo().getName();
    }

    public int numberOfGames(){
        return this.game.getScoreGamePlayerOne()+this.game.getScoreGamePlayerTwo();
    }

    public boolean hasWinner(){
        return this.game.whoWinner()!=null;
    }

    public TennisGame getGame() {
        return game;
    }

    public String randomWinAPlay(){
        Random r = new Random();
        if(r.nextInt(2)==0){
            return this.winAPlay(this.game.getPlayerOne(), this.game.getPlayerTwo());
        }else{
            return this.winAPlay(this.game.getPlayerTwo(), this.game.getPlayerOne());
        }
    }
}