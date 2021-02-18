package screens;

public class IntroScreen implements ScreenPrinter {

    //no constructor needed since this is just an introduction screen also this class has no sub-class..
    private static final String intro =
            "   ___   _   __  __ ___ _  _  ___   ___  ___ __  __  ___  _  _ ___  \n" +
            "  / __| /_\\ |  \\/  |_ _| \\| |/ __| |   \\| __|  \\/  |/ _ \\| \\| / __| \n" +
            " | (_ |/ _ \\| |\\/| || || .` | (_ | | |) | _|| |\\/| | (_) | .` \\__ \\ \n" +
            "  \\___/_/ \\_\\_| _|_|___|_|\\_|\\___|_|___/|___|_|__|_|\\___/|_|\\_|___/ \n" +
            "               | _ \\ _ \\ __/ __| __| \\| |_   _/ __|                 \n" +
            "               |  _/   / _|\\__ \\ _|| .` | | | \\__ \\                 \n" +
            "               |_| |_|_\\___|___/___|_|\\_| |_| |___/   \n";



    @Override
    public void printScreen() {
        System.out.printf("%s%n", intro);
    }
}
