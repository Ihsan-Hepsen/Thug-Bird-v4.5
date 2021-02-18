package screens;

import leaderboard.LeaderBoard;

import java.sql.*;

public class HighScoreScreen extends MainMenuScreen implements ScreenPrinter {

    public HighScoreScreen() {
    }

    private final ResultSet resultSet = null;

    @Override
    public void printScreen() {
        String banner = "LeaderBoard is loading, please wait";
        String scoreColumn = "<< SCORE >>";
        String playerNameColumn = "<< Player >>";
        String highScores = "  _  _ ___ ___ _  _   ___  ___ ___  ___ ___ ___ \n" +
                " | || |_ _/ __| || | / __|/ __/ _ \\| _ \\ __/ __|\n" +
                " | __ || | (_ | __ | \\__ \\ (_| (_) |   / _|\\__ \\\n" +
                " |_||_|___\\___|_||_| |___/\\___\\___/|_|_\\___|___/\n";
        System.out.printf("%s%n%s%n%s%32s%n", highScores, banner, playerNameColumn, scoreColumn);
    }

    public void printSqlScores() {
        try {
            LeaderBoard leaderBoard = new LeaderBoard();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}
