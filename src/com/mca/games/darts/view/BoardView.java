/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts.view;

import com.mca.games.darts.controller.DartsGameController;
import com.mca.games.darts.util.Constants;
import com.mca.games.darts.util.ImageCache;
import com.mca.games.darts.util.Util;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyListener;

/**
 *
 * @author user
 */
public class BoardView extends Frame {
//    private LobberCell[][] cells;
//    private LobberCell lastPlayerSelectedCell;
//    private LobberCell lastOpponentSelectedCell;
//    private LobberCell lastFocusCell;
Container localContainer;
private KeyListener listener;
    void initializeCells() {
//        cells = new LobberCell[Util.getRowCount()][Util.getColumnCount()];
//        int cellWidth = getWidth() / Util.getColumnCount();
//        int cellHeight = getHeight() / Util.getRowCount();
//        int cellY_Pos, cellX_Pos;
//        System.out.println("cells.length = " + cells.length);
//        for (int row = 0; row < cells.length; row++) //Each row
//        {
//            cellY_Pos = cellHeight * row;
//            System.out.println("cells[row].length = " + cells[row].length);
//            for (int column = 0; column < cells[row].length; column++)
//            {
//                cellX_Pos = cellWidth * column;
//                LobberCell cell = cells[row][column] = new LobberCell();
//                cell.setBounds(cellX_Pos, cellY_Pos, cellWidth - 1, cellHeight - 1);
//                add(cell);
//                cell.setVisible(true);
//            }
//        }
    }

//    void shiftFocusToCell(GridPosition currentPos)
//    {
//       LobberCell currentFocusCell = cells[currentPos.getRow()][currentPos.getColumn()];
//       currentFocusCell.setHighlighted(true);
//       if ((null != lastFocusCell) && (lastFocusCell != currentFocusCell))
//       {
//           lastFocusCell.setHighlighted(false);
//       }
//       lastFocusCell = currentFocusCell;
//    }
//
//    void selectCell(GridPosition currentPos, byte cellValue)
//    {
//        LobberCell currentSelectedCell = cells[currentPos.getRow()][currentPos.getColumn()];
//        currentSelectedCell.setCellValue(cellValue);
//        currentSelectedCell.setSelected(true);
//        switch (cellValue)
//        {
//            case CellContent.OPPONENT_CELL:
//                if (null != lastOpponentSelectedCell)
//                {
//                    lastOpponentSelectedCell.setSelected(false);
//                }
//                lastOpponentSelectedCell = currentSelectedCell;
//                break;
//            case CellContent.PLAYER_CELL:
//                if (null != lastPlayerSelectedCell)
//                {
//                    lastPlayerSelectedCell.setSelected(false);
//                }
//                lastPlayerSelectedCell = currentSelectedCell;
//                break;
//        }
//    }
//
//    void reset(boolean difficultyLevelChange)
//    {
//        if (difficultyLevelChange)
//        {
//            this.removeAll();
//            initializeCells();
//            repaint();
//        } else
//        {
//            for (int row = 0; row < cells.length; row++)
//            {
//                for (int column = 0; column < cells[row].length; column++)
//                {
//                    LobberCell cell = cells[row][column];
//                    cell.setCellValue(CellContent.NON_FILLED_CELL);
//                    cell.setSelected(false);
//                    cell.setHighlighted(false);
//                }
//            }
//        }
//    }
    public void initGui() {
        this.setBounds(Constants.APP_X_POS, Constants.APP_Y_POS,
                Constants.APP_WIDTH, Constants.APP_HEIGHT);
        this.setBackground(Color.black);
        localContainer = new Container() {
            public void paint(Graphics g) {
                g.drawImage(ImageCache.getImage("resources/Background.png"), 0, 0,
                        Constants.APP_WIDTH, Constants.APP_HEIGHT, null);
                super.paint(g);
            }
        };
        localContainer.setBounds(getBounds());
        
        

        CrosshairView crosshair = new CrosshairView();
        crosshair.setBounds(Constants.GRID_X_POS,
                Constants.GRID_Y_POS, 600, 600);
        localContainer.add(crosshair);
        crosshair.setVisible(true);
        
        Thread t1 = new Thread(crosshair);
        t1.start();
        
        
        this.add(localContainer);
    }

    public void setKeyListener(DartsGameController controller) {
        this.listener = controller;
    }
}
