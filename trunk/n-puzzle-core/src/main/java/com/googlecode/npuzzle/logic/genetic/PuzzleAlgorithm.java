/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.logic.genetic;

import com.googlecode.npuzzle.logic.PuzzleState;
import org.encog.neural.NeuralNetworkError;
import org.encog.solve.genetic.GeneticAlgorithm;

/**
 *
 * @author thiago
 */
public class PuzzleAlgorithm extends GeneticAlgorithm<Integer> {

    public PuzzleAlgorithm(final PuzzleState state, final int populationSize,
            final double mutationPercent, final double percentToMate,
            final double matingPopulationPercent, final int cutLength)
            throws NeuralNetworkError {
        setMutationPercent(mutationPercent);
        setMatingPopulation(matingPopulationPercent);
        setPopulationSize(populationSize);
        setPercentToMate(percentToMate);
        setCutLength(cutLength);
        setPreventRepeat(false);

        setChromosomes(new PuzzleChromosome[getPopulationSize()]);
        for (int i = 0; i < getChromosomes().length; i++) {
            final PuzzleChromosome c = new PuzzleChromosome(this, state);
            setChromosome(i, c);
        }
        sortChromosomes();
    }
}
