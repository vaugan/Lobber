/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mca.games.darts.util;

/**
 *
 * @author user
 */
public class Util
{
    private static int difficultyLevel = Constants.LEVEL_MEDIUIM;

    public static void setDifficultyLevel(int level)
    {
        difficultyLevel = level;
    }

    public static int getRowCount()
    {
        int rowCount = 0;
        switch (difficultyLevel)
        {
            case Constants.LEVEL_EASY:
                rowCount = Constants.EASY_LEVEL_ROW_COUNT;
                break;
            case Constants.LEVEL_MEDIUIM:
                rowCount = Constants.MEDIUIM_LEVEL_ROW_COUNT;
                break;
            case Constants.LEVEL_DIFFICULT:
                rowCount = Constants.DIFFICULT_LEVEL_ROW_COUNT;
                break;
        }
        return rowCount;
    }

    public static int getColumnCount()
    {
        int columnCount = 0;
        switch (difficultyLevel)
        {
            case Constants.LEVEL_EASY:
                columnCount = Constants.EASY_LEVEL_COLUMN_COUNT;
                break;
            case Constants.LEVEL_MEDIUIM:
                columnCount = Constants.MEDIUIM_LEVEL_COLUMN_COUNT;
                break;
            case Constants.LEVEL_DIFFICULT:
                columnCount = Constants.DIFFICULT_LEVEL_COLUMN_COUNT;
                break;
        }
        return columnCount;
    }
}
