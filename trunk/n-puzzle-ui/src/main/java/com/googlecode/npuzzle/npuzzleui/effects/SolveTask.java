/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.npuzzleui.effects;

import com.googlecode.npuzzle.npuzzleui.Board;
import org.apache.pivot.util.concurrent.Task;
import org.apache.pivot.util.concurrent.TaskExecutionException;

/**
 *
 * @author thiago
 */
public class SolveTask extends Task<Boolean> {

    private final Board board;

    public SolveTask(Board board) {
        this.board = board;
    }

    @Override
    public Boolean execute() throws TaskExecutionException {
        board.getController().startSolving();
        return true;
    }
}
