/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.npuzzleui.effects;

import com.googlecode.npuzzle.npuzzleui.Board;
import com.googlecode.npuzzle.npuzzleui.StatusBar.Status;
import org.apache.pivot.wtk.effects.Transition;

/**
 *
 * @author thiago
 */
public class RefreshTransition extends Transition {

    private final Board board;
    public static final int RATE = 1;
    public static final int DURATION = 1;

    public RefreshTransition(Board board) {
        super(DURATION, RATE, true);
        this.board = board;
    }

    @Override
    protected void update() {
        int bufferSize = board.getController().commandBufferSize();
        if (bufferSize > 0) {
            board.moveAnimation();
            board.repaint();
        } else if (board.getStatusBar().getStatus() == Status.MOVING && bufferSize == 0) {
            board.getMenu().stopedStatus();
        }
        board.getStatusBar().setBufferSize(board.getController().commandBufferSize());
    }
}
