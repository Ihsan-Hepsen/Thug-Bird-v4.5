package screens;

public class GameOverScreen extends MainMenuScreen implements ScreenPrinter {

    public GameOverScreen() {}

    @Override
    public void printScreen() {
        String gameOverBanner = "  ____   ____  ___ ___    ___       ___   __ __    ___  ____   __ \n" +
                " /    | /    ||   |   |  /  _]     /   \\ |  |  |  /  _]|    \\ |  |\n" +
                "|   __||  o  || _   _ | /  [_     |     ||  |  | /  [_ |  D  )|  |\n" +
                "|  |  ||     ||  \\_/  ||    _]    |  O  ||  |  ||    _]|    / |__|\n" +
                "|  |_ ||  _  ||   |   ||   [_     |     ||  :  ||   [_ |    \\  __ \n" +
                "|     ||  |  ||   |   ||     |    |     | \\   / |     ||  .  \\|  |\n" +
                "|___,_||__|__||___|___||_____|     \\___/   \\_/  |_____||__|\\_||__|";
        System.out.printf("%s%n", gameOverBanner);
    }

}
