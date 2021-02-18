package saveNload;

import game.Player;

import java.sql.*;

public class SaveAndLoad {
    private final ResultSet resultSet = null;
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@thugbird_medium?TNS_ADMIN=D:/Intellij-IDEA/Thug Bird Final Release/database2", "thugbird", "Gamingdemonboys2020");

    public SaveAndLoad() throws SQLException {}

    public int getPlayerId(String playerName) throws SQLException {
        String getPlayerId = "SELECT player_id FROM PLAYERS WHERE player_name = '" + playerName + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(getPlayerId);
        int s = 0;
        while (rs.next()) {
            s = rs.getInt(1);
        }
        return s;
    }

    public void saveGameData(int playerId, int score, int xManColAxis, int xManRowAxis,
                       int birdColAxis, int birdRowAxis, int poopColAxis,
                       int poopRowAxis) throws SQLException {
        String saveGameData = " INSERT INTO GAME_POS_DATA VALUES(" + playerId + ", " + score + ", " + xManColAxis + ", " + xManRowAxis + ", " + birdColAxis + ", " + birdRowAxis + ", " + poopColAxis + ", " + poopRowAxis + ") ";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(saveGameData);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void loadGame(int playerId) {
        int[] gamePositions = new int[8];

    }
}

