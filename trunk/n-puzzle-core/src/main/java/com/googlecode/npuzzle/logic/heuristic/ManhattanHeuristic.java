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
public class ManhattanHeuristic implements Heuristic {

    @Override
    public double getCost(PuzzleState first, PuzzleState second) {
        Integer[] aux1 = ((PuzzleState<Integer>) first).representation();
        Integer[] aux2 = ((PuzzleState<Integer>) second).representation();
        Integer result = 0;
        for (int i = 0; i < aux1.length; i++) {
            result += Math.abs(aux1[i] - aux2[i]);
        }
        return result;
    }
}
