/*
 *  Copyright 2010 thiago.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
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
