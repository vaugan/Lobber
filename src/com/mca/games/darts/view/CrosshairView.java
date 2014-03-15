/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts.view;

import com.mca.games.darts.util.Constants;
import com.mca.games.darts.controller.DartsGameController;
import com.mca.games.darts.util.ImageCache;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;

/**
 *
 * @author user
 */
public class CrosshairView extends Component implements Runnable {

    private KeyListener listener;

    private Image image;
    boolean isHighlighted;
    boolean isSelected;
    int cellValue; //CellContent
    int x, y;
    private float angle;
    private final int RADIUS = 218;
    private int tempRadius = RADIUS;
    private int segmentMovement = Constants.TOWARDS_BULLSEYE;
    Container localContainer;
    private final int DELAY = 50;
    private int state = Constants.MOVE_AROUND_BOARD;

    public CrosshairView() {
        image = ImageCache.getImage(Constants.CROSSHAIR);
    }

    public void setKeyListener(KeyListener keyListener) {
        this.listener = keyListener;
    }

    void setHighlighted(boolean highlightStatus) {
        this.isHighlighted = highlightStatus;
        updateImage();
        this.repaint();
    }

    void setSelected(boolean selectStatus) {
        this.isSelected = selectStatus;
        updateImage();
        this.repaint();
    }

    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
        updateImage();
        this.repaint();
    }

    public void paint(Graphics g) {
//        g.drawImage(image, x, y, 80, 80, this);
//        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private void updateImage() {
        int index = (int) ((angle * 10) % 5);
        image = ImageCache.getImage(Constants.CROSSHAIR_IMAGES[index]);

//        System.out.println("Index="+index + " Image="+image);
    }

    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            //update coordinates
            if (state == Constants.MOVE_AROUND_BOARD) {
                moveCrosshairAroundBoard();
            } else {
                moveCrosshairInSegment();
            }

            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }

    private void moveCrosshairAroundBoard() {

        if (angle > 360) {
            angle = 0;
        } else {
            angle += 0.1;
        }
        x = (int) (Math.cos(angle) * RADIUS) + 288;
        y = (int) (Math.sin(angle) * RADIUS) + 270;
        updateImage();

//        this.setBounds(x-40,
//                y-40, 100, 100);
        System.out.println("moveCrosshairAroundBoard:");
        System.out.println("x=" + x);
        System.out.println("y=" + y);
    }

    private void moveCrosshairInSegment() {

        switch (segmentMovement) {
            case Constants.TOWARDS_BULLSEYE:
                if (tempRadius < 0) {
                    tempRadius = 0;
                    segmentMovement = Constants.AWAY_FROM_BULLSEYE;
                } else {
                    tempRadius -= 10;
                }
                break;
            case Constants.AWAY_FROM_BULLSEYE:
                if (tempRadius > RADIUS) {
                    tempRadius = RADIUS;
                    segmentMovement = Constants.TOWARDS_BULLSEYE;
                } else {
                    tempRadius += 10;
                }
                break;
        }

        x = (int) (Math.cos(angle) * tempRadius) + 288;
        y = (int) (Math.sin(angle) * tempRadius) + 270;
        updateImage();

//        this.setBounds(x-40,
//                y-40, 100, 100);
        System.out.println("moveCrosshairInSegment:");
        System.out.println("x=" + x);
        System.out.println("y=" + y);
    }

    void updateState(int crosshairState) {
        state = crosshairState;
    }

    public void initGui() {
//        this.setBounds(Constants.APP_X_POS, Constants.APP_Y_POS,
//                Constants.APP_WIDTH, Constants.APP_HEIGHT);
//        this.setBackground(Color.black);
//        localContainer = new Container() {
//            public void paint(Graphics g) {
//                g.drawImage(ImageCache.getImage("resources/Background.png"), 0, 0,
//                        Constants.APP_WIDTH, Constants.APP_HEIGHT, null);
//                super.paint(g);
//            }
//        };
//        localContainer.setBounds(getBounds());
//
//        this.add(localContainer);
    }


    public void showUI() {
        this.setVisible(true);
//        this.addKeyListener(listener);
//        this.requestFocus();    
    }

    public void updateCrosshairState(int crosshairState) {
        state = crosshairState;
    }
}
