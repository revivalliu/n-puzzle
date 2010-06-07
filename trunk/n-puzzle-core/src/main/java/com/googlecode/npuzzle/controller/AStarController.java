/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.controller;

import com.googlecode.npuzzle.logic.Command;
import com.googlecode.npuzzle.logic.EigthPuzzleState;
import com.googlecode.npuzzle.logic.PuzzleState;
import com.googlecode.npuzzle.logic.astar.AStarTree;
import com.googlecode.npuzzle.logic.astar.NodeImpl;
import com.googlecode.npuzzle.logic.astar.Path;
import com.googlecode.npuzzle.logic.astar.PathFinder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiago
 */
public class AStarController extends BaseController {

    private PuzzleState idealState = new EigthPuzzleState();

    public AStarController(PuzzleState initialState) {
        super(initialState);
    }

    public AStarController(PuzzleState initialState, PuzzleState idealState) {
        super(initialState);
        this.idealState = idealState;
    }

    @Override
    public void startSolving() {
        solving = true;
        List<Command> commands = generateCommands(initialState);
        for (Command command : commands) {
            bufferCommand.add(command);
        }
        solving = false;
    }

    private List<Command> generateCommands(PuzzleState initialState) {
        PathFinder aStar = new AStarTree();
        long init = System.currentTimeMillis();
        Path path = aStar.findPath(new NodeImpl(initialState),
                new NodeImpl(idealState));
        long end = System.currentTimeMillis();
        System.out.println("Duration : " + (end - init) + ", size: " + path.getLength());
        return pathToCommands(path);
    }

    private List<Command> pathToCommands(Path path) {
        List<Command> commands = new ArrayList<Command>();
        if (path != null) {
            for (int i = 1; i < path.getLength(); i++) {
                PuzzleState stateA = ((NodeImpl) path.getNode(i - 1)).getState();
                PuzzleState stateB = ((NodeImpl) path.getNode(i)).getState();
                commands.add(stateB.commandDiff(stateA));
            }
        }
        return commands;
    }
}
