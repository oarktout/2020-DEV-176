package tennis.kata.view;

import tennis.kata.controller.TennisGameController;

import java.util.Scanner;

public class TennisGameView {
    private TennisGameController gameController;
    private String playerOneName;
    private String playerTwoName;

    public TennisGameView(){
    }

    public void launch(){
        int choice=menu();
        if (choice == 1) {
            initializeTheGame();
        }else{
            System.out.println("the choice it's not valid , return to the menu...");
            launch();
        }
    }
    private static int menu(){
        Scanner sc =new Scanner(System.in);

        System.out.println("Tennis Game Menu");
        System.out.println("=================");
        System.out.println("1. Generate a play");
        System.out.println("==================");
        System.out.println("Enter The Value (an integer): ");


        while (!sc.hasNextInt()){
            System.out.println("its not an integer , reinsert pls : ");
            sc=new Scanner(System.in);
        }
        return sc.nextInt();
    }


    private void initializeTheGame() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Name Player one :");
        this.playerOneName=sc.next();
        System.out.println("Enter Name Player two:");
        this.playerTwoName=sc.next();
        this.gameController=new TennisGameController(playerOneName,playerTwoName);
        System.out.println("How many game you want to play? ");
        int numberOfGame=sc.nextInt();
        play(numberOfGame);
    }

    private void play(int numberOfGame) {
        Scanner scanner=new Scanner(System.in);
        while(this.gameController.numberOfGames() < numberOfGame && !this.gameController.hasWinner()) {
            System.out.println("\n"+this.gameController.randomWinAPlay());
            displayScore();
        }
        System.out.println("replay? (y/n)");
        String response=scanner.next();
        if("y".equals(response)){
            initializeTheGame();
        }else{
            launch();
        }
    }

    private void displayScore() {
        System.out.println("Score");
        System.out.println("=====");
        System.out.println("Score "+ this.gameController.getPlayerOneName()+": "+this.gameController.getScorePlayerOne());
        System.out.println("Game :"+this.gameController.getGame().getScoreGamePlayerOne());
        System.out.println("Score "+ this.gameController.getPlayerTwoName()+": "+this.gameController.getScorePlayerTwo());
        System.out.println("Game :"+this.gameController.getGame().getScoreGamePlayerTwo());
    }

}