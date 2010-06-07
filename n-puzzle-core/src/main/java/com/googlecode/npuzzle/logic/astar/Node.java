/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.logic.astar;

import java.util.Set;

/**
 *
 * @author thiago
 */
public abstract class Node implements Comparable<Node> {

    protected float cost;
    protected float heuristic;
    protected int depth;
    protected Node parent;

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(float heuristic) {
        this.heuristic = heuristic;
    }

    public Node getParent() {
        return parent;
    }

    public int setParent(Node parent) {
        if (parent != null) {
            depth = parent.depth + 1;
            this.parent = parent;
            return depth;
        } else {
            parent = null;
            return -1;
        }
    }

    public abstract Set<Node> getNeighbours();

    public abstract float costDifference(Node other);
}
