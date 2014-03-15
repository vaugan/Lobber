/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts.model;

import com.mca.games.darts.util.Constants;
import com.mca.games.darts.util.Util;
import com.mca.games.darts.view.CrosshairView;
import com.mca.games.darts.view.DartView;

/**
 *
 * @author user
 */
public class CrosshairModel {

    CrosshairView view;
    byte[][] playGrid;
    private int state;

    public CrosshairModel(CrosshairView view) {
        this.view = view;
        view.initGui();
    }

    public void start() {
        view.showUI();
    }

    public void moveRight() {
    }

    public void moveLeft() {
    }

    public void moveDown() {
    }

    public void moveUp() {
    }

    public void handleOKButton() {

        //Change movement of crosshair or launch dart.
        System.out.println("OK PRESSED!!!!!!!!");
        view.updateCrosshairState(Constants.MOVE_IN_SEGMENT);
    }

    private void displayStatus(int status) {
//        this.state = status;
//        view.displayStatus(status);
    }

    public void reset(boolean difficultyLevelChange) {
//        playGrid = new byte[Util.getRowCount()][Util.getColumnCount()];
//        view.reset(difficultyLevelChange);
//        logic.reset();
//        currentOpponentPos = new GridPosition(Util.getRowCount() / 2, Util.getColumnCount() / 2);
//        shiftFocusToCell(currentOpponentPos);
//        displayStatus(DartsState.WELCOME_PLAYER);
    }

}
