package com.master;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Fitness.setSolution(random.toString());

        // Se initializeaza populatia
        Population myPop = new Population(50, true);

        // Se evolueaza populatia pana gasim o solutie optima
        int generationCount = 0;
        while (myPop.getFitElit().getFitness() < Fitness.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFitElit().getFitness());
            myPop = Algorithm.evolvePopulation(myPop);
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFitElit());
    }
}
