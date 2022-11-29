package com.master;

public class Individ {

    static int geneLength = 50;
    private byte[] genes = new byte[geneLength];
    private int fitness = 0;

    // Se creaza random un individ
    public void generateIndivid() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    // Pentru a crea indivizi cu diferite gene
    public static void setDefaultGeneLength(int length) {
        geneLength = length;
    }

    public byte getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0;
    }

    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = Fitness.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        StringBuilder geneString = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            geneString.append(getGene(i));
        }
        return geneString.toString();
    }

}
