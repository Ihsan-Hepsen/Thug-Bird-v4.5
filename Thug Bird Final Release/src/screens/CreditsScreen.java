package screens;

public class CreditsScreen extends MainMenuScreen implements ScreenPrinter {

    public CreditsScreen() {}

    @Override
    public void printScreen() {
        String contributors = ">> Ihsan Hepsen <<\n" +
                ">> Amrani Mohamed <<\n" +
                ">> Tsering Sawa <<\n" +
                ">> Dhondup Lobsang <<";
        String creditsHeading = "                 ___ ___ ___ ___ ___ _____ ___               \n" +
                "            ___ / __| _ \\ __|   \\_ _|_   _/ __|___           \n" +
                "           |___| (__|   / _|| |) | |  | | \\__ \\___|          \n" +
                "    ___         \\___|_|_\\___|___/___| |_| |___/              \n" +
                "   / __|__ _ _ __ (_)_ _  __ _   |   \\ ___ _ __  ___ _ _  ___\n" +
                "  | (_ / _` | '  \\| | ' \\/ _` |  | |) / -_) '  \\/ _ \\ ' \\(_-<\n" +
                "   \\___\\__,_|_|_|_|_|_||_\\__, |  |___/\\___|_|_|_\\___/_||_/__/";
        System.out.printf("%s%n%n%s%n", creditsHeading, contributors);
    }
}
