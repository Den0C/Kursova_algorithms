package com.example.kursovavisual;

public class OperationData {

    private int numVertex2;
    private long numAssignmentBruteForce;
    private long numAssignmentTarjan;
    private long numComparisonBruteForce;
    private long numComparisonTarjan;
    private long sumBruteForce;
    private long sumTarjan;

    public OperationData(int numVertex2, long numAssignmentTarjan,long numAssignmentBruteForce,
                         long numComparisonTarjan, long numComparisonBruteForce) {

        this.numVertex2 = numVertex2;
        this.numAssignmentBruteForce = numAssignmentBruteForce;
        this.numAssignmentTarjan = numAssignmentTarjan;
        this.numComparisonBruteForce = numComparisonBruteForce;
        this.numComparisonTarjan = numComparisonTarjan;

        this.sumBruteForce = numAssignmentBruteForce + numComparisonBruteForce;
        this.sumTarjan = numAssignmentTarjan + numComparisonTarjan;
    }

    public int getNumVertex2() {
        return numVertex2;
    }

    public void setNumVertex2(int numVertex2) {
        this.numVertex2 = numVertex2;
    }

    public long getNumAssignmentBruteForce() {
        return numAssignmentBruteForce;
    }

    public void setNumAssignmentBruteForce(long numAssignmentBruteForce) {
        this.numAssignmentBruteForce = numAssignmentBruteForce;
    }

    public long getNumAssignmentTarjan() {
        return numAssignmentTarjan;
    }

    public void setNumAssignmentTarjan(long numAssignmentTarjan) {
        this.numAssignmentTarjan = numAssignmentTarjan;
    }

    public long getNumComparisonBruteForce() {
        return numComparisonBruteForce;
    }

    public void setNumComparisonBruteForce(long numComparisonBruteForce) {
        this.numComparisonBruteForce = numComparisonBruteForce;
    }

    public long getNumComparisonTarjan() {
        return numComparisonTarjan;
    }

    public void setNumComparisonTarjan(long numComparisonTarjan) {
        this.numComparisonTarjan = numComparisonTarjan;
    }

    public long getSumBruteForce() {
        return sumBruteForce;
    }

    public void setSumBruteForce(long sumBruteForce) {
        this.sumBruteForce = sumBruteForce;
    }

    public long getSumTarjan() {
        return sumTarjan;
    }

    public void setSumTarjan(long sumTarjan) {
        this.sumTarjan = sumTarjan;
    }
}
