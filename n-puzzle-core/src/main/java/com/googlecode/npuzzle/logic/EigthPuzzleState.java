/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.logic;

import java.util.Arrays;

/**
 *
 * @author thiago
 */
public class EigthPuzzleState extends BasePuzzleState {

    public EigthPuzzleState() {
        super(9);
    }

    @Override
    public void moveUp(int pos) {
        move(pos, pos - 3);
    }

    @Override
    public void moveDown(int pos) {
        move(pos, pos + 3);
    }

    @Override
    public void moveLeft(int pos) {
        move(pos, pos - 1);
    }

    @Override
    public void moveRight(int pos) {
        move(pos, pos + 1);
    }

    private void move(int pos, int newPos) {
        if (newPos >= 0 && newPos <= 8) {
            if ((pos == 2 && newPos == 3) || (pos == 5 && newPos == 6)) {
                return;
            }
            if ((pos == 3 && newPos == 2) || (pos == 6 && newPos == 5)) {
                return;
            }
            swap(pos, newPos);
        }
    }

    @Override
    public synchronized boolean isGoalReached() {
        Integer[] goal = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        return Arrays.deepEquals(state, goal);
    }

    @Override
    public Command commandDiff(PuzzleState state) {
        int cmd = this.emptyBlock() - state.emptyBlock();
        switch (cmd) {
            case 3:
                return Command.DOWN;
            case -3:
                return Command.UP;
            case 1:
                return Command.RIGHT;
            case -1:
                return Command.LEFT;
            case 0:
                return null;
            default:
                throw new IllegalArgumentException("No command can be defined for this difference.");
        }
    }

    @Override
    public PuzzleState copyState() {
        EigthPuzzleState newState = new EigthPuzzleState();
        synchronized (state) {
            System.arraycopy(state, 0, newState.state, 0, state.length);
            return newState;
        }
    }
}
