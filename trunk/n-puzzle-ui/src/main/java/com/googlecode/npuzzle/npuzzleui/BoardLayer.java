/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.npuzzleui;

import org.apache.pivot.wtk.GridPane;

/**
 *
 * @author thiago
 */
public class BoardLayer extends GridPane {

    private int rows = 3;
    private int columns = 3;
    private final Board board;
    private final boolean target;

    public BoardLayer(Board parent, int point, int value) {
        setColumnCount(columns);
        this.board = parent;
        target = (value == 0) ? true : false;
        drawLayer(point, value);
    }

    private void drawLayer(int point, int value) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            GridPane.Row row = new GridPane.Row();
            for (int j = 0; j < columns; j++) {
                int h = getHoaxHeight();
                int w = getHoaxWidth();
                if (count == point) {
                    if (value == 0) {
                        row.add(new GridPane.Filler());
                    } else {
                        row.add(new Hoax(w, h, value));
                    }
                } else {
                    row.add(new GridPane.Filler());
                }
                count++;
            }
            getRows().add(row);
        }
    }

    public int getHoaxHeight() {
        return board.getHeight() / rows;
    }

    public int getHoaxWidth() {
        return board.getWidth() / columns;
    }

    public boolean isTargetLayer() {
        return target;
    }

}
