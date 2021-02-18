package leaderboard;

import java.sql.*;

public class LeaderBoard {

//    private final ResultSet resultSet = null;
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@thugbird_medium?TNS_ADMIN=D:/Intellij-IDEA/Thug Bird Final Release/database2", "thugbird", "Gamingdemonboys2020");

    public LeaderBoard(String playerName, int score) throws SQLException {
        String insert = " INSERT INTO PLAYERS VALUES(auto_player_id.nextval, '" + playerName + "', '" + score + "') ";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(insert);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public LeaderBoard() throws SQLException {
        String retrieve = " SELECT player_name, score FROM players ORDER BY SCORE DESC FETCH FIRST 9 ROWS ONLY";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(retrieve);
        int position = 1;
        while (rs.next()) {
            String playerName = rs.getString(1);
            System.out.printf("%d-%-17s", position, playerName);
            String score = rs.getString(2);
            System.out.printf("%22s", score);
            position++;
            System.out.println();
        }
    }

//    public ResultSet getScoreTable() {
//        return resultSet;
//    }
}
