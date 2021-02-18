package game;

import characters.*;
import saveNload.SaveAndLoad;

import java.sql.SQLException;
import java.util.Scanner;

public class GameAction {

    PlayScreen playScreen = new PlayScreen();
    GameCharacter birdGameCharacter = new GameCharacter();
    GameCharacter xMan = new GameCharacter();
    GameCharacter poop = new GameCharacter();

    protected GameAction() {
    }

    private void setPlayerCharacter(GameCharacter XMan) {
        this.xMan = XMan;
    }

    private void setBirdCharacter(GameCharacter bird) {
        this.birdGameCharacter = bird;
    }

    private void setPoop(GameCharacter poop) {
        this.poop = poop;
    }

    private void clearPoop() {
        playScreen.rectangle[poop.getColumnAxis() + 1][poop.getRowAxis()] = "   ";
    }

    // initializing the game screen
    private void initializePlayScreen() {
        playScreen.screenInitializer();
    }

    // positioning GameCharacter
    private void positionGameCharacters() {
        // initializing
        GameCharacter xMan = new XMan(playScreen.rectangle[0].length / 2, playScreen.rectangle.length - 2);
        playScreen.rectangle[xMan.getColumnAxis()][xMan.getRowAxis()] = xMan.getDisplayCharacter();

        GameCharacter bird = new Bird(playScreen.rectangle[0].length / 2, 2);
        playScreen.rectangle[bird.getColumnAxis()][bird.getRowAxis()] = bird.getDisplayCharacter();

        GameCharacter poop = new Poop(playScreen.rectangle[0].length / 2, bird.getColumnAxis() + 1);
        playScreen.rectangle[poop.getColumnAxis()][poop.getRowAxis()] = poop.getDisplayCharacter();

        // positioning
        setBirdCharacter(bird);
        setPlayerCharacter(xMan); // the shape is 'X'
        setPoop(poop);
    }

    protected void makePlayScreenReadyForGamePlay() {
        initializePlayScreen();
        positionGameCharacters();
    }

    protected void moveBirdAndPoop() {
        moveBird();
        dropPoop();
    }

    protected void printPlayScreen() {
        playScreen.printScreen();
    }

    protected boolean collision() {
        int poopColPos = poop.getColumnAxis();
        int poopRowPos = poop.getRowAxis();
        int xManColPos = xMan.getColumnAxis();
        int xManRowPos = xMan.getRowAxis();
        // Poop's and XMan's next move is going to collide ==> Game Over!
        return (poopRowPos == xManRowPos) && (poopColPos + 1 == xManColPos + 1);
        //        if ((poopRowPos == xManRowPos) && (poopColPos + 1 == xManColPos - 1)) {
//            return true;
//        }
    }

    // setting GameCharacters to Default (their initial positions)
    private void setBirdToDefault() {
        playScreen.rectangle[birdGameCharacter.getColumnAxis()][birdGameCharacter.getRowAxis()] = "   ";
        birdGameCharacter.setRowAxis(playScreen.rectangle[0].length / 2);
        birdGameCharacter.setColumnAxis(2);
        playScreen.rectangle[birdGameCharacter.getColumnAxis()][birdGameCharacter.getRowAxis()] = birdGameCharacter.getDisplayCharacter();
    }

    private void setPlayerCharacterToDefault() {
        playScreen.rectangle[xMan.getColumnAxis()][xMan.getRowAxis()] = "   ";
        xMan.setRowAxis(playScreen.rectangle[0].length / 2);
        xMan.setColumnAxis(playScreen.rectangle.length - 2);
        playScreen.rectangle[xMan.getColumnAxis()][xMan.getRowAxis()] = xMan.getDisplayCharacter();
    }

    private void setPoopToDefault() {
        playScreen.rectangle[poop.getColumnAxis()][poop.getRowAxis()] = "   ";
        poop.setRowAxis(playScreen.rectangle[0].length / 2);
        poop.setColumnAxis(3);
        playScreen.rectangle[poop.getColumnAxis()][poop.getRowAxis()] = poop.getDisplayCharacter();
    }

    protected void setAllCharactersToDefault() {
        clearPoop();
        setBirdToDefault();
        setPlayerCharacterToDefault();
        setPoopToDefault();
    }

    // moving GameCharacters methods
    protected void moveXManRight() {
        playScreen.rectangle[xMan.getColumnAxis()][xMan.getRowAxis()] = "   ";

        if (xMan.getRowAxis() + 1 == playScreen.rectangle[0].length - 1) { // if near wall
            xMan.setRowAxis(1); // because 0: wall
        } else {
            xMan.setRowAxis(xMan.getRowAxis() + 1);
        }

        playScreen.rectangle[xMan.getColumnAxis()][xMan.getRowAxis()] = xMan.getDisplayCharacter();
    }

    // | _ _ _ _ _ _ |
    // 0 1 2 3 4 5 6 7
    protected void moveXManLeft() {
        playScreen.rectangle[xMan.getColumnAxis()][xMan.getRowAxis()] = "   ";

        if (xMan.getRowAxis() - 1 == 0) { // if near wall
            xMan.setRowAxis(playScreen.rectangle[0].length - 2); // rectangle[0].length - 1: wall
        } else {
            xMan.setRowAxis(xMan.getRowAxis() - 1);
        }

        playScreen.rectangle[xMan.getColumnAxis()][xMan.getRowAxis()] = xMan.getDisplayCharacter();
    }

    private void moveBird() {
        playScreen.rectangle[birdGameCharacter.getColumnAxis()][birdGameCharacter.getRowAxis()] = "   ";

        if (birdGameCharacter.getRowAxis() - 1 == 0) { // near wall
            birdGameCharacter.setRowAxis(playScreen.rectangle[0].length - 2); // -2 to avoid walls
        } else {
            birdGameCharacter.setRowAxis(birdGameCharacter.getRowAxis() - 2); // will move 2 place at a time
        }

        playScreen.rectangle[birdGameCharacter.getColumnAxis()][birdGameCharacter.getRowAxis()] = birdGameCharacter.getDisplayCharacter();
    }

    private void dropPoop() {
        int initialPos = xMan.getRowAxis();
        playScreen.rectangle[poop.getColumnAxis()][poop.getRowAxis()] = "   ";

        if (poop.getColumnAxis() + 1 == playScreen.rectangle.length - 1) {
            playScreen.rectangle[poop.getColumnAxis()][poop.getRowAxis()] = "   ";
            poop.setColumnAxis(birdGameCharacter.getColumnAxis() + 1);
            clearPoop();
            setPoopToBird();
        }
//        else if(initialPos % 3 == 0) {
//            GameCharacter secondPoop = new Poop(birdGameCharacter.getColumnAxis(), birdGameCharacter.getRowAxis());
//            setPoopToBird();
//        }

        else {
            poop.setColumnAxis(poop.getColumnAxis() + 1);
            playScreen.rectangle[poop.getColumnAxis()][poop.getRowAxis()] = poop.getDisplayCharacter();
        }
    }

    private void setPoopToBird() {
        poop.setRowAxis(birdGameCharacter.getRowAxis());
        poop.setColumnAxis(birdGameCharacter.getColumnAxis() + 1);
        playScreen.rectangle[poop.getColumnAxis()][poop.getRowAxis()] = poop.getDisplayCharacter();
    }

    protected void askToSaveTheGame(String playerName, int score) {
        SaveAndLoad saveAndLoad = null;
        try {
            saveAndLoad = new SaveAndLoad();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in); // not static or final because only this method needs it
        System.out.print("\nDo you want to save the current game(y/n)? ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {

            try {
                saveAndLoad.saveGameData(saveAndLoad.getPlayerId(playerName), xMan.getColumnAxis(), xMan.getRowAxis(),
                        birdGameCharacter.getColumnAxis(), birdGameCharacter.getRowAxis(),
                        poop.getColumnAxis(), poop.getRowAxis(), score);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (answer.equalsIgnoreCase("N")) {
            System.out.println("Exiting without saving.");
        }
    }
}
