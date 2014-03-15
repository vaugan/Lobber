/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts.model;

import com.mca.games.darts.util.Constants;
import com.mca.games.darts.util.Util;

/**
 *
 * @author user
 */
public class DartModel {

    com.mca.games.darts.view.DartView view;
    private int state;

    public DartModel(com.mca.games.darts.view.DartView view) {
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

    public void processSelection() {

        //Change movement of  dart.
        System.out.println("OK PRESSED!!!!!!!!");
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
