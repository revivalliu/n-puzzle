/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.controller;

import com.googlecode.npuzzle.logic.Command;
import com.googlecode.npuzzle.logic.PuzzleState;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author thiago
 */
public abstract class BaseController implements Controller {

    private Random random = new Random();
    protected final Queue<Command> bufferCommand = new LinkedBlockingQueue<Command>();
    protected boolean solving = false;
    protected final PuzzleState initialState;

    public BaseController(PuzzleState initialState) {
        this.initialState = initialState;
    }

    @Override
    public final void randomize() {
        synchronized (bufferCommand) {
            if (bufferCommand.isEmpty()) {
                for (int i = 0; i < 100; i++) {
                    int val = random.nextInt(4);
                    bufferCommand.offer(Command.values()[val]);
                }
            }
            execCommandsBuffer();
        }
    }

    @Override
    public void addCommand(Command cmd) {
        System.out.println("No command accepted.");
    }

    @Override
    public final void execCommand() {
        Command cmd = bufferCommand.poll();
        //notify
        if (cmd != null) {
            initialState.command(cmd);
        }
    }

    @Override
    public final void execCommandsBuffer() {
        synchronized (bufferCommand) {
            while (!bufferCommand.isEmpty()) {
                execCommand();
            }
        }
    }

    @Override
    public final Integer commandBufferSize() {
        synchronized (bufferCommand) {
            return bufferCommand.size();
        }
    }

    @Override
    public void stopSolving() {
        solving = false;
    }
}
