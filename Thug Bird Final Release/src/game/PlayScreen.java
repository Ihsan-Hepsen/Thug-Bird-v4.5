package game;

import screens.ScreenPrinter;

import java.util.Scanner;

public class PlayScreen implements ScreenPrinter {
    private static final Scanner scanner = new Scanner(System.in);

    protected final String[][] rectangle = new String[14][19];
    protected final String scoreIndicator = "> Score: ";
    protected final float scoreIncrementRate = 2.31059f; //as long as you do not die your score will go up

    protected PlayScreen() {
    }

    protected void screenInitializer() {
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[0].length; j++) {
                if (j < rectangle[0].length - 1) {
                    rectangle[i][j] = "   ";
                    if (j == 0) {
                        rectangle[i][j] = " │ ";
                    } else if (i == rectangle.length - 1) {
                        rectangle[i][j] = "───";
                    } else if (i == 0) {
                        rectangle[i][j] = "───";
                    }
                } else {
                    rectangle[i][j] = " │ ";
                }
            }
            rectangle[0][0] = " ┌ ";
            rectangle[rectangle.length - 1][0] = " └ ";
            rectangle[0][rectangle[0].length - 1] = " ┐ ";
            rectangle[rectangle.length - 1][rectangle[0].length - 1] = " ┘ ";
        }
    }

    protected void drawScreen(String[][] screen) {
        for (String[] rows : screen) {
            for (String s : rows) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    protected void goBackMessage() {
        System.out.println("< Press 'enter' to go back >");
    }

    protected void pressEnterToContinue() {
        String pressEnter = "< Press 'Enter' to continue >";
        System.out.printf("%s%n", pressEnter);
        scanner.nextLine();
    }

    protected void playerNameBanner() {
        String playerNameScreen =
                "   ___ _                       _   _                                 \n" +
                        "  / __| |_  ___  ___ ___ ___  | | | |___ ___ _ _ _ _  __ _ _ __  ___ \n" +
                        " | (__| ' \\/ _ \\/ _ (_-</ -_) | |_| (_-</ -_) '_| ' \\/ _` | '  \\/ -_)\n" +
                        "  \\___|_||_\\___/\\___/__/\\___|  \\___//__/\\___|_| |_||_\\__,_|_|_|_\\___|";
        System.out.printf("%s%nChose your player name: ", playerNameScreen);
    }

    protected void getReadyBanner() {
        String getReadyBanner =
                "   ____      _     ____                _       _ \n" +
                        "  / ___| ___| |_  |  _ \\ ___  __ _  __| |_   _| |\n" +
                        " | |  _ / _ \\ __| | |_) / _ \\/ _` |/ _` | | | | |\n" +
                        " | |_| |  __/ |_  |  _ <  __/ (_| | (_| | |_| |_|\n" +
                        "  \\____|\\___|\\__| |_| \\_\\___|\\__,_|\\__,_|\\__, (_)\n" +
                        "                                         |___/   ";
        String gameControls = "Press \"A\" to move left, press \"D\" to move right\n\"Enter \"E\" to exit game.\"";
        System.out.println(getReadyBanner + "\n" + gameControls);
        pressEnterToContinue();
    }

    @Override
    public void printScreen() {
        drawScreen(rectangle);
    }
}
