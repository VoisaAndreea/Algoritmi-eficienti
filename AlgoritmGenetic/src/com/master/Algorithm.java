package com.master;

public class Algorithm {

    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.05;
    private static final int tournamentSize = 3;
    private static final boolean elitism = true;

    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

        if (elitism) {
            newPopulation.saveIndividual(0, pop.getFitElit());
        }

        // Crossover
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }

        for (int i = elitismOffset; i < pop.size(); i++) {
            Individ indiv1 = tournamentSelection(pop);
            Individ indiv2 = tournamentSelection(pop);
            Individ newIndiv = crossover(indiv1, indiv2);
            newPopulation.saveIndividual(i, newIndiv);
        }

        // Mutatie
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndivid(i));
        }

        return newPopulation;
    }


    private static Individ crossover(Individ indiv1, Individ indiv2) {
        Individ newSol = new Individ();

        for (int i = 0; i < indiv1.size(); i++) {
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

    private static void mutate(Individ indiv) {

        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    // Selectare individ pentru crossover
    private static Individ tournamentSelection(Population pop) {

        Population tournament = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndivid(randomId));
        }

        return tournament.getFitElit();
    }
}
