/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.controller;

import com.googlecode.npuzzle.logic.Command;

/**
 *
 * @author thiago
 */
public interface Controller {

    void startSolving();

    void stopSolving();

    void addCommand(Command cmd);

    void randomize();

    void execCommand();

    void execCommandsBuffer();

    Integer commandBufferSize();
}
