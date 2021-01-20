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
        switch (choice){
            case 1:
                initializeTheGame();
            default:
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

    }

}