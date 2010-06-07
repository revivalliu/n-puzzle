/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.controller;

import com.googlecode.npuzzle.logic.Command;
import com.googlecode.npuzzle.logic.PuzzleState;

/**
 *
 * @author thiago
 */
public class HumanController extends BaseController {

    public HumanController(PuzzleState initialState) {
        super(initialState);
    }

    @Override
    public void addCommand(Command cmd) {
        if (cmd != null) {
            bufferCommand.offer(cmd);
            //wait
        }
    }

    @Override
    public void startSolving() {
        System.out.println("No solve implementation!!");
    }
}
