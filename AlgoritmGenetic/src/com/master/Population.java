package com.master;

public class Population {
    Individ[] individuals;

    public Population(int populationSize, boolean initialise) {
        individuals = new Individ[populationSize];

        if (initialise) {
            // Pentru crearea indiviziilor din populatie
            for (int i = 0; i < size(); i++) {
                Individ newIndividual = new Individ();
                newIndividual.generateIndivid();
                saveIndividual(i, newIndividual);
            }
        }
    }

    public Individ getIndivid(int index) {
        return individuals[index];
    }

    public Individ getFitElit() {
        Individ fittest = individuals[0];

        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndivid(i).getFitness()) {
                fittest = getIndivid(i);
            }
        }
        return fittest;
    }


    public int size() {
        return individuals.length;
    }

    public void saveIndividual(int index, Individ indiv) {
        individuals[index] = indiv;
    }
}
