/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.logic;

/**
 *
 * @author thiago
 */
public enum Command {

    UP, DOWN, LEFT, RIGHT;

    public static Command opposite(Command cmd) {
        switch (cmd) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                throw new IllegalArgumentException("No Command found.");
        }
    }
}
