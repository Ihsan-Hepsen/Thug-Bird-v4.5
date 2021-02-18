package game;

public class Player {

    private String playerName;
    private int score;

    protected Player() {}

    protected void setPlayerName(String PlayerName) {
        this.playerName = PlayerName;
    }

    protected String getPlayer() {
        return playerName;
    }

    protected void setScore(int score) {
        this.score = score;
    }

    protected int getScore() {
        return score;
    }
}
