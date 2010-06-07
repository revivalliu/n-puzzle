/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.npuzzle.npuzzleui.effects;

import com.googlecode.npuzzle.logic.Command;
import com.googlecode.npuzzle.npuzzleui.BoardLayer;
import org.apache.pivot.wtk.effects.Transition;

/**
 *
 * @author thiago
 */
public class HoaxTransition extends Transition {

        private final BoardLayer layer;
        private Command command;
        private final int initialX;
        private final int initialY;
        public static final int RATE = 50;
        public static final int DURATION = 100;

        public HoaxTransition(BoardLayer layer, Command command) {
            super(DURATION, RATE, false);
            this.command = command;
            this.layer = layer;
            initialX = layer.getX();
            initialY = layer.getY();
        }

        @Override
        protected void update() {
            float percentComplete = getPercentComplete();
            if (percentComplete <= 1.0f) {
                int x = (int) (initialX + isPositiveOrNegative(command) * (layer.getHoaxWidth() * percentComplete));
                int y = (int) (initialY + isPositiveOrNegative(command) * (layer.getHoaxHeight() * percentComplete));
                if (isHorizontal(command)) {
                    layer.setX(x);
                } else {
                    layer.setY(y);
                }
                layer.repaint();
            }
        }

        private int isPositiveOrNegative(Command command) {
            return (command == Command.UP || command == Command.LEFT) ? -1 : 1;
        }

        private boolean isHorizontal(Command command) {
            return (command == Command.RIGHT || command == Command.LEFT) ? true : false;
        }
    }
