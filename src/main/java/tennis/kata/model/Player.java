package tennis.kata.model;

public class Player {
    private String name;
    private int score;
    private int scoreGame;
    private boolean advantage;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.scoreGame=0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getScoreGame() {
        return scoreGame;
    }

    public void wonAGame() {
        this.scoreGame++;
        this.score=0;
    }

    public void wonAPoint(){
        score++;
    }

    public boolean isAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScoreGame(int scoreGame) {
        this.scoreGame = scoreGame;
    }
}
