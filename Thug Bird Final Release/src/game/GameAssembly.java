package game;

import leaderboard.LeaderBoard;
import saveNload.SaveAndLoad;
import screens.*;

import java.sql.*;
import java.util.Scanner;

public class GameAssembly {

    // setting up final constants
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_PLAYER_NAME_LENGTH = 13;
    private static final int MIN_PLAYER_NAME_LENGTH = 2;
    private int score = 0;

    protected IntroScreen introScreen = new IntroScreen();
    protected Player player = new Player();
    protected GameAction gameAction = new GameAction();
    protected PlayScreen playScreen = new PlayScreen();
    protected MainMenuScreen[] gameScreens = {new MainMenuScreen(), new SettingsScreen(), new HighScoreScreen(),
            new CreditsScreen(), new GameOverScreen()};

    // constructor
    public GameAssembly() {
    }

    // the entire program will run with all its features
    public void runThugBird() {
            startThugBird();
    }

    private void startThugBird() {
        introScreen.printScreen();
        playScreen.pressEnterToContinue();

        boolean stayOnMenu = true;

        while (stayOnMenu) {

            gameScreens[0].printScreen();
            String menuOption = scanner.nextLine();

            if (menuOption.equalsIgnoreCase("P")) {
                playScreen.playerNameBanner();
                letPlayerChooseName();
                playOnCommand();
            }
            if (menuOption.equalsIgnoreCase("S")) {
                gameScreens[1].printScreen();
                playScreen.goBackMessage(); //tells user to how user can go back
                scanner.nextLine();
            } else if (menuOption.equalsIgnoreCase("H")) {
                gameScreens[2].printScreen();
                HighScoreScreen highScoreScreen = new HighScoreScreen();
                highScoreScreen.printSqlScores();
                playScreen.goBackMessage();
                scanner.nextLine();
            } else if (menuOption.equalsIgnoreCase("C")) {
                gameScreens[3].printScreen();
                playScreen.goBackMessage();
                scanner.nextLine();
            } else if (menuOption.equalsIgnoreCase("Q")) {
                stayOnMenu = false;
            }
        }
    }

    private void playOnCommand() {
        boolean keepPlaying = true;
        playScreen.getReadyBanner();

        gameAction.makePlayScreenReadyForGamePlay();
        score = 0;
        while (keepPlaying) {
            gameAction.printPlayScreen();
            System.out.println();
            String pressedKey = scanner.next();

            if (pressedKey.equalsIgnoreCase("A")) {
                gameAction.moveXManLeft();
                gameAction.moveBirdAndPoop();
                if (gameAction.collision()) {
                    keepPlaying = false;
                    gameAction.printPlayScreen();
                    gameScreens[4].printScreen(); // prints Game Over Screen
                }
                player.setScore(score += playScreen.scoreIncrementRate);
                System.out.println(playScreen.scoreIndicator + player.getScore());
            } else if (pressedKey.equalsIgnoreCase("D")) {
                gameAction.moveXManRight();
                gameAction.moveBirdAndPoop();

                if (gameAction.collision()) {
                    keepPlaying = false;
                    gameAction.printPlayScreen();
                    gameScreens[4].printScreen(); // prints Game Over Screen
                }
                player.setScore(score += playScreen.scoreIncrementRate);
                System.out.println(playScreen.scoreIndicator + player.getScore());

            } else if (pressedKey.equalsIgnoreCase("E")) {
                try {
                    new LeaderBoard(player.getPlayer(), player.getScore());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                gameAction.askToSaveTheGame(player.getPlayer(), player.getScore());
                gameAction.setAllCharactersToDefault();
                gameScreens[4].printScreen(); // prints Game Over Screen
//                player.setScore(0);
                keepPlaying = false;
            }
        }
        gameAction.setAllCharactersToDefault();
        scanner.nextLine();
        System.out.println("Game Over '" + player.getPlayer() + "'");
        playScreen.pressEnterToContinue();
    }

    private void letPlayerChooseName() {
        boolean isPlayerNameOk = true;

        while (isPlayerNameOk) {
            String chosenPlayerName = scanner.nextLine();

            if (chosenPlayerName.length() > MAX_PLAYER_NAME_LENGTH) {
                System.out.println("Player name cannot be longer than 13 characters!");
            } else if (chosenPlayerName.length() < MIN_PLAYER_NAME_LENGTH) {
                System.out.println("Player name must be at least two-character long!");

            } else isPlayerNameOk = false;
            player.setPlayerName(chosenPlayerName);
        }

    }


}
