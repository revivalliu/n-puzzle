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
public abstract class BasePuzzleState implements PuzzleState<Integer>, Cloneable {

    protected final Integer[] state;

    public BasePuzzleState(int size) {
        state = new Integer[size];
        for (int i = 1; i < state.length; i++) {
            state[i - 1] = i;
        }
        state[size - 1] = 0;
    }

    @Override
    public synchronized void swap(int pos, int newPos) {
        Integer aux = state[pos];
        state[pos] = state[newPos];
        state[newPos] = aux;
    }

    @Override
    public int emptyBlock() {
        int pos = -1;
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    @Override
    public void command(Command command) {
        int pos = emptyBlock();
        switch (command) {
            case UP:
                moveUp(pos);
                break;
            case DOWN:
                moveDown(pos);
                break;
            case LEFT:
                moveLeft(pos);
                break;
            case RIGHT:
                moveRight(pos);
                break;
        }
    }

    @Override
    public boolean canMove(Command command) {
        PuzzleState copy = this.copyState();
        copy.command(command);
        Command cmd = commandDiff(copy);
        return (cmd == null) ? false : true;
    }

    @Override
    public String toString() {
        synchronized (state) {
            return Arrays.toString(state);
        }
    }

    @Override
    public boolean equals(Object o) {
        BasePuzzleState otherState = (BasePuzzleState) o;
        synchronized (state) {
            return Arrays.equals(state, otherState.state);
        }
    }

    @Override
    public Integer[] representation() {
        synchronized (state) {
            return Arrays.copyOf(state, state.length);
        }
    }
}
