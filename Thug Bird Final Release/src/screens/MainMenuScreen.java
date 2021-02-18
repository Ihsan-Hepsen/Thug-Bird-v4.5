package screens;

import java.sql.SQLException;

public class MainMenuScreen implements ScreenPrinter {

    public MainMenuScreen() {}

    @Override
    public void printScreen()  {
        String play = "> PLAY - enter 'P' <";
        String settings = "> SETTINGS - enter 'S' <";
        String highScores = "> HIGH SCORES - enter 'H' <";
        String credits = "> CREDITS - enter 'C' <";
        String quitGame = "> Enter \"Q\" to exit <";
        String gameName = "  ________  ____  ________   ____  ________  ____ \n" +
                " /_  __/ / / / / / / ____/  / __ )/  _/ __ \\/ __ \\\n" +
                "  / / / /_/ / / / / / __   / __  |/ // /_/ / / / /\n" +
                " / / / __  / /_/ / /_/ /  / /_/ // // _, _/ /_/ / \n" +
                "/_/ /_/ /_/\\____/\\____/  /_____/___/_/ |_/_____/  \n" +
                "                                                 ";
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n", gameName, play, settings, highScores, credits, quitGame);
    }
}
