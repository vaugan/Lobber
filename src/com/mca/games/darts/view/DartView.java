/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts.view;

import com.mca.games.darts.util.Constants;
import com.mca.games.darts.util.ImageCache;
import com.mca.games.darts.util.VideoHandler;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyListener;

/**
 *
 * @author user
 */
public class DartView extends Frame
{
//    private LobberGrid grid;
    private KeyListener listener;
//    private ImageBoxView statusBox;
//    private ImageBoxView helpText;
    Container localContainer;
    private ImageBoxView appTitle;
    private CrosshairView crosshair;

    public void initGui()
    {
        this.setBounds(Constants.APP_X_POS, Constants.APP_Y_POS,
                Constants.APP_WIDTH, Constants.APP_HEIGHT);
        this.setBackground(Color.black);
        localContainer = new Container() {
            public void paint(Graphics g)
            {
                g.drawImage(ImageCache.getImage("resources/Background.png"), 0, 0,
                        Constants.APP_WIDTH, Constants.APP_HEIGHT, null);
                super.paint(g);
            }
        };
        localContainer.setBounds(getBounds());
        
        
        createCrosshair();
        
        
        createAppTitle();
        createLobberGrid();
        createStatusDisplay();
        createHelpDisplay();
//        createAdvtSlideShow();
        this.add(localContainer);
        this.setResizable(false);
//        VideoHandler.resizeVideo(new Rectangle(LobberConstants.VIDEO_X_POS,
//                LobberConstants.VIDEO_Y_POS, LobberConstants.VIDEO_WIDTH,
//                LobberConstants.VIDEO_HEIGHT));
        
        
    }


    public void setKeyListener(KeyListener keyListener)
    {
        this.listener = keyListener;
    }
    private void createCrosshair()
    {
        crosshair = new CrosshairView();
        crosshair.setBounds(Constants.GRID_X_POS,
                Constants.GRID_Y_POS, 600, 600);
        localContainer.add(crosshair);
        crosshair.setVisible(true);
        
        Thread t1 = new Thread(crosshair);
        t1.start();
    }

    private void createLobberGrid()
    {
//        grid = new LobberGrid();
//        grid.setBounds(LobberConstants.GRID_X_POS,
//                LobberConstants.GRID_Y_POS, LobberConstants.GRID_WIDTH, LobberConstants.GRID_HEIGHT);
//        System.out.println("Frame Bounds is " + getBounds());
//        System.out.println("Grid Bounds is " + grid.getBounds());
//        grid.initializeCells();
//        localContainer.add(grid);
//        grid.setVisible(true);
    }

    private void createStatusDisplay()
    {
//        statusBox = new ImageBoxView();
//        statusBox.setBounds(LobberConstants.STATUS_X_POS, LobberConstants.STATUS_Y_POS,
//                LobberConstants.STATUS_WIDTH, LobberConstants.STATUS_HEIGHT);
//        localContainer.add(statusBox);
//        statusBox.setVisible(true);
    }


    public void updateCrosshairState(int state)
    {
        crosshair.updateState(state);
    }
    
    

    public void displayStatus(int status)
    {
//        switch (status)
//        {
//            case DartsState.OPPONENT_WON:
//                statusBox.setImage(LobberConstants.OPPONENT_WON_STATUS_IMAGE);
//                break;
//            case DartsState.PLAYER_THINKING:
//                statusBox.setImage(LobberConstants.PLAYER_THINKING_STATUS_IMAGE);
//                break;
//            case DartsState.PLAYER_WON:
//                statusBox.setImage(LobberConstants.PLAYER_WON_STATUS_IMAGE);
//                break;
//            case DartsState.WAITING_FOR_OPPONENT:
//                statusBox.setImage(LobberConstants.WAITING_FOR_OPPONENT_STATUS_IMAGE);
//                break;
//            case DartsState.GAME_DRAWN:
//                statusBox.setImage(LobberConstants.GAME_DRAWN_STATUS_IMAGE);
//                break;
//            case DartsState.WELCOME_PLAYER:
//                statusBox.setImage(LobberConstants.WELCOME_AND_WAIT_STATUS_IMAGE);
//                break;
//        }
//        updateHelpText(status);
    }

    private void updateHelpText(int status)
    {
//        switch (status)
//        {
//            case DartsState.OPPONENT_WON:
//            case DartsState.PLAYER_WON:
//            case DartsState.GAME_DRAWN:
//                helpText.setImage(LobberConstants.HELP_IMAGE_PLAY_OVER);
//                break;
//            case DartsState.PLAYER_THINKING:
//            case DartsState.WAITING_FOR_OPPONENT:
//                helpText.setImage(LobberConstants.HELP_IMAGE_PLAYING);
//                break;
//            case DartsState.WELCOME_PLAYER:
//                helpText.setImage(LobberConstants.HELP_IMAGE_START);
//                break;
//        }
    }

    public void reset(boolean difficultyLevelChange)
    {
//        statusBox.setImage(LobberConstants.WELCOME_AND_WAIT_STATUS_IMAGE);
//        grid.reset(difficultyLevelChange);
    }

    public void showUI()
    {
        this.setVisible(true);
        this.addKeyListener(listener);
        this.requestFocus();
    }

    private void createHelpDisplay()
    {
//        helpText = new ImageBoxView();
//        helpText.setBounds(LobberConstants.HELPTEXT_X_POS, LobberConstants.HELPTEXT_Y_POS,
//                LobberConstants.HELPTEXT_WIDTH, LobberConstants.HELPTEXT_HEIGHT);
//        helpText.setImage(LobberConstants.HELP_IMAGE_START);
//        localContainer.add(helpText);
//        helpText.setVisible(true);
    }

    private void createAdvtSlideShow()
    {
        SlideshowView slideShow = new SlideshowView();
        slideShow.setBounds(Constants.ADVT_X_POS, Constants.ADVT_Y_POS,
                Constants.ADVT_WIDTH, Constants.ADVT_HEIGHT);
        slideShow.setDelay(10000);
        slideShow.setSlides(Constants.ADVT_SLIDESHOW_IMAGES);
        localContainer.add(slideShow);
        slideShow.startSlideShow();
        slideShow.setVisible(true);
    }

    private void createAppTitle()
    {
        appTitle = new ImageBoxView();
        appTitle.setBounds(Constants.APP_TITLE_X_POS, Constants.APP_TITLE_Y_POS,
                Constants.APP_TITLE_WIDTH, Constants.APP_TITLE_HEIGHT);
        appTitle.setImage(Constants.APP_TITLE_IMAGE);
        localContainer.add(appTitle);
        appTitle.setVisible(true);
    }
}
