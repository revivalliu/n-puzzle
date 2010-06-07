package com.googlecode.npuzzle.logic.astar;

import java.util.ArrayList;

/**
 * A path determined by some path finding algorithm. A series of steps from
 * the starting location to the target location. This includes a step for the
 * initial location.
 * 
 * @author Kevin Glass
 */
public class Path {

    /** The list of steps building up this path */
    private ArrayList nodes = new ArrayList();

    /**
     * Create an empty path
     */
    public Path() {
    }

    /**
     * Get the length of the path, i.e. the number of steps
     *
     * @return The number of steps in this path
     */
    public int getLength() {
        return nodes.size();
    }

    /**
     * Get the step at a given index in the path
     *
     * @param index The index of the step to retrieve. Note this should
     * be >= 0 and < getLength();
     * @return The step information, the position on the map.
     */
    public Node getNode(int index) {
        return (Node) nodes.get(index);
    }

    /**
     * Append a step to the path.
     *
     * @param x The x coordinate of the new step
     * @param y The y coordinate of the new step
     */
    public void appendStep(Node node) {
        nodes.add(node);
    }

    /**
     * Prepend a step to the path.
     *
     * @param x The x coordinate of the new step
     * @param y The y coordinate of the new step
     */
    public void prependStep(Node node) {
        nodes.add(0, node);
    }

    /**
     * Check if this path contains the given step
     *
     * @param x The x coordinate of the step to check for
     * @param y The y coordinate of the step to check for
     * @return True if the path contains the given step
     */
    public boolean contains(Node node) {
        return nodes.contains(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object node : nodes) {
            sb.append(node);
            sb.append("\n");
        }

        return sb.toString();
    }
}
