/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts.model;

import com.mca.games.darts.util.Constants;
import com.mca.games.darts.util.Util;
import com.mca.games.darts.view.BoardView;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Devadas.Vijayan
 
 This class will calculate the score of any co-ordinate on the board.
 */
public class BoardModel
{
    BoardView view;

    public BoardModel(BoardView view)
    {
        this.view = view;
        view.initGui();
        
    }

    public void reset(boolean difficultyLevelChange) {
//        playGrid = new byte[Util.getRowCount()][Util.getColumnCount()];
//        view.reset(difficultyLevelChange);
//        logic.reset();
//        currentOpponentPos = new GridPosition(Util.getRowCount() / 2, Util.getColumnCount() / 2);
//        shiftFocusToCell(currentOpponentPos);
//        displayStatus(DartsState.WELCOME_PLAYER);
    }

    public void start() {
        view.setVisible(true);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
