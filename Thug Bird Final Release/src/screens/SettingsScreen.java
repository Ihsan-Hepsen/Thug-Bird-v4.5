package screens;

public class SettingsScreen extends MainMenuScreen implements ScreenPrinter {

    private static final String settingScreenHeading =
            " __  ___  ___  ___  _  _  _  __  __ \n" +
            "/ _|| __||_ _||_ _|| || \\| |/ _|/ _|\n" +
            "\\_ \\| _|  | |  | | | || \\\\ ( |_n\\_ \\\n" +
            "|__/|___| |_|  |_| |_||_|\\_|\\__/|__/" +
            "                                    ";
    private static final String settingsDescriptions = "<<< Game Controls >>>";
    private static final String keyCommands = "Move Left >> A\nMove Right >> D\nEnd Game >> E";

    public SettingsScreen() {}

    @Override
    public void printScreen() {
        System.out.printf("%s%n%n%s%n%s%n", settingScreenHeading, settingsDescriptions, keyCommands);
    }
}
