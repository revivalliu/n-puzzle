/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.logic;

/**
 *
 * @author thiago
 */
public interface PuzzleState<E> {

    public void swap(int pos, int newPos);

    public int emptyBlock();

    public void command(Command command);

    public boolean canMove(Command command);

    public boolean isGoalReached();

    public void moveUp(int pos);

    public void moveDown(int pos);

    public void moveLeft(int pos);

    public void moveRight(int pos);

    public Command commandDiff(PuzzleState state);

    public PuzzleState copyState();

    public E[] representation();
}
