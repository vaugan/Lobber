/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts;

import com.mca.games.darts.view.DartView;
import com.mca.games.darts.model.DartModel;
import com.mca.games.darts.controller.DartsGameController;
import com.mca.games.darts.model.BoardModel;
import com.mca.games.darts.model.CrosshairModel;
import com.mca.games.darts.view.BoardView;
import com.mca.games.darts.view.CrosshairView;

/**
 *
 * @author Devadas.Vijayan
 */
public class DartsGame
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new DartsGame().startApp();
    }

    private void startApp()
    {
        BoardView view = new BoardView();
        BoardModel model = new BoardModel(view);
//        CrosshairView view = new CrosshairView();
//        CrosshairModel model = new CrosshairModel(view);
        DartsGameController controller = new DartsGameController();
        view.setKeyListener(controller);
        controller.setModel(model);
        controller.startPlay();
    }
}
