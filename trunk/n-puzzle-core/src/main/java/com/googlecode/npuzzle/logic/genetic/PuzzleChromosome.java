/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.logic.genetic;

import com.googlecode.npuzzle.logic.Command;
import com.googlecode.npuzzle.controller.Controller;
import com.googlecode.npuzzle.controller.GAEncogController;
import com.googlecode.npuzzle.controller.HumanController;
import com.googlecode.npuzzle.logic.EigthPuzzleState;
import com.googlecode.npuzzle.logic.PuzzleState;
import com.googlecode.npuzzle.logic.heuristic.ManhattanHeuristic;
import com.googlecode.npuzzle.logic.heuristic.Heuristic;
import java.util.Random;
import org.encog.solve.genetic.Chromosome;

/**
 *
 * @author thiago
 */
public class PuzzleChromosome extends Chromosome<Integer> {

    private final PuzzleState state;
    private final Random random = new Random();
    private Heuristic heuristicCost;
    private PuzzleState idealState;

    /*public PuzzleChromosome(final PuzzleAlgorithm ga, PuzzleState state, Heuristic heuristicCost, PuzzleState idealState) {
        this.heuristicCost = heuristicCost;
        this.idealState = idealState;
        setGeneticAlgorithm(ga);
        this.state = state.copyState();
        Integer[] gene = new Integer[GAEncogController.GENE_SIZE];
        for (int i = 0; i < gene.length; i++) {
            gene[i] = random.nextInt(4);
        }
        setGenes(gene);
        calculateScore();
    }*/

    public PuzzleChromosome(final PuzzleAlgorithm ga, PuzzleState state) {
        heuristicCost = new ManhattanHeuristic();
        idealState = new EigthPuzzleState();
        setGeneticAlgorithm(ga);
        this.state = state.copyState();
        Integer[] gene = new Integer[GAEncogController.GENE_SIZE];
        for (int i = 0; i < gene.length; i++) {
            gene[i] = random.nextInt(4);
        }
        setGenes(gene);
    }

    @Override
    public void mutate() {
        Integer[] rep = getGenes();
        int rand = random.nextInt(rep.length);
        int val = random.nextInt(4);
        rep[rand] = val;
        setGenes(rep);
    }

    @Override
    public void calculateScore() {
        PuzzleState cp = state.copyState();
        Controller controller = new HumanController(cp);
        for (Integer val : getGenes()) {
            controller.addCommand(Command.values()[val]);
        }
        controller.execCommandsBuffer();
        Integer distance = (int) heuristicCost.getCost(cp, idealState);
        setScore(1.0 / (distance + 1));
    }
}
