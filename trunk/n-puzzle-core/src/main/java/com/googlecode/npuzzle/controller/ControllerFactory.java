/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.controller;

import com.googlecode.npuzzle.logic.PuzzleState;

/**
 *
 * @author thiago
 */
public class ControllerFactory {

    public static Controller createController(String name, PuzzleState state) {
        if ("human".equalsIgnoreCase(name)) {
            return new HumanController(state);
        } else if ("a*".equalsIgnoreCase(name)) {
            return new AStarController(state);
        } else if ("genetic".equalsIgnoreCase(name)) {
            return new GAEncogController(state);
        } else if ("annealing".equalsIgnoreCase(name)) {
            return new SimulatedController(state);
        } else {
            throw new IllegalArgumentException("Invalid Controller.");
        }
    }
}
