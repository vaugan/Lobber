/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dstvo.lobber.view;

import com.dstvo.lobber.LobberConstants;
import com.dstvo.lobber.controller.LobberController;
import com.dstvo.lobber.model.CellContent;
import com.dstvo.lobber.util.ImageCache;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author user
 */
public class Crosshair extends Component implements Runnable {

    private Image image;
    boolean isHighlighted;
    boolean isSelected;
    int cellValue; //CellContent
    int x, y;
    private float angle;
    private final int RADIUS = 218;
    private int tempRadius = RADIUS;
    private int segmentMovement = LobberConstants.TOWARDS_BULLSEYE;

    private final int DELAY = 50;
    private int state = LobberConstants.MOVE_AROUND_BOARD;

    public Crosshair() {
        image = ImageCache.getImage(LobberConstants.CROSSHAIR);
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
        image = ImageCache.getImage(LobberConstants.CROSSHAIR_IMAGES[index]);

//        System.out.println("Index="+index + " Image="+image);
    }

    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            //update coordinates
            if (state == LobberConstants.MOVE_AROUND_BOARD) {
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
            case LobberConstants.TOWARDS_BULLSEYE:
                if (tempRadius < 0) {
                    tempRadius = 0;
                    segmentMovement = LobberConstants.AWAY_FROM_BULLSEYE;
                } else {
                    tempRadius -= 10;
                }
                break;
            case LobberConstants.AWAY_FROM_BULLSEYE:
                if (tempRadius > RADIUS) {
                    tempRadius = RADIUS;
                    segmentMovement = LobberConstants.TOWARDS_BULLSEYE;
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
}
