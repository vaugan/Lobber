/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts.controller;

import com.mca.games.darts.model.BoardModel;
import com.mca.games.darts.model.CrosshairModel;
import com.mca.games.darts.util.Constants;
import com.mca.games.darts.util.Util;
import com.mca.games.darts.model.DartModel;
import com.mca.games.darts.view.BoardView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Devadas.Vijayan
 */
public class DartsGameController implements KeyListener
{
    private BoardModel model;
//    private CrosshairModel crosshairModel;
//    private DartModel dartModel;
    private boolean matchInProgress;

    public void setModel(BoardModel model)
    {
        this.model = model;
    }

    public void startPlay()
    {
        model.start();
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT:
//                model.moveRight();
                break;
            case KeyEvent.VK_LEFT:
//                model.moveLeft();
                break;
            case KeyEvent.VK_UP:
//                model.moveUp();
                break;
            case KeyEvent.VK_DOWN:
//                model.moveDown();
                break;
            case KeyEvent.VK_ENTER:
                matchInProgress = true;
//                model.handleOKButton();
                break;
            case KeyEvent.VK_1:
                matchInProgress = false;
                model.reset(false);
                break;
            case KeyEvent.VK_9:
                if (!matchInProgress)
                {
                    Util.setDifficultyLevel(Constants.LEVEL_DIFFICULT);
                    model.reset(true);
                }
                break;
            case KeyEvent.VK_8:
                if (!matchInProgress)
                {
                    Util.setDifficultyLevel(Constants.LEVEL_MEDIUIM);
                    model.reset(true);
                }
                break;
            case KeyEvent.VK_7:
                if (!matchInProgress)
                {
                    Util.setDifficultyLevel(Constants.LEVEL_EASY);
                    model.reset(true);
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e)
    {
    }

}
