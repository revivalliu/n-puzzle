/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.logic.heuristic;

import com.googlecode.npuzzle.logic.PuzzleState;

/**
 *
 * @author thiago
 */
public interface Heuristic {

    public double getCost(PuzzleState first, PuzzleState second);
}
